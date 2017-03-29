package com.su.schedule.spy.handler.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.TeacherConstant;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import com.su.schedule.model.po.Teacher;
import com.su.schedule.model.vo.TimeTableModel;
import com.su.schedule.spy.connnet.impl.PeizhengHttpConnectImpl;
import com.su.schedule.spy.connnet.impl.PeizhengPageParamHeaderSimulate;
import com.su.schedule.spy.handler.PeizhengHandler;
import com.su.schedule.spy.resolver.impl.PeizhengHtmlResolver;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by shj on 2017/3/29.
 */
@Component(value = "PeizhengHandlerImpl")
public class PeizhengHandlerImpl implements PeizhengHandler{
    @Autowired
    @Qualifier(value = "peizhengHttpConnect")
    private PeizhengHttpConnectImpl peizhengHttpConnect;
    @Autowired
    @Qualifier(value = "peizhengPageParamHeaderSimulate")
    private PeizhengPageParamHeaderSimulate pageParamHeaderSimulate;
    @Autowired
    @Qualifier(value = "peizhengHtmlResolver")
    private PeizhengHtmlResolver peizhengHtmlResolver;

    private Map<String,Teacher> teacherMap;

    private Map<String,List<TimeTableModel>> timeTableModelMap;

    @PostConstruct
    public void init(){
        try {
          this.teacherMap =   this.peizhengHtmlResolver.resolveTeacher(TeacherConstant.TEACHER_CONTENT);
          this.timeTableModelMap = new HashMap<String, List<TimeTableModel>>();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean insertValidateCode(String code) throws Exception {
        String html = this.peizhengHttpConnect.executeRequest(this.peizhengHttpConnect.httpPostSimulate(this.pageParamHeaderSimulate.getTimableQueryRequest(code, Constant.DEFAULT_TEST_TEACHER_ID)),true);
        List<TimeTableModel> timeTableModels = this.peizhengHtmlResolver.resolveClassDetail(html,"shj",7);
        if(timeTableModels==null)
            return false;
        this.peizhengHttpConnect.setValidateCode(code);
        return true;
    }

    public byte[] getValidatePic() throws Exception {

        return this.peizhengHttpConnect.getValidate();
    }

    public List<TimeTableModel> queryTimetable(DataSendExtend dataSend) throws Exception {
        List<TimeTableModel> timeTableModels = this.timeTableModelMap.get(dataSend.getTeacherName());
        if(CollectionUtils.isEmpty(timeTableModels)){
            String teacherName = dataSend.getTeacherName();
            Integer weekNo = dataSend.getWeekNum();
            String html = this.peizhengHttpConnect.executeRequest(this.peizhengHttpConnect.httpPostSimulate(this.pageParamHeaderSimulate.getTimableQueryRequest(this.peizhengHttpConnect.getValidateCode(),this.teacherMap.get(teacherName).getLevel())),true);
            List<TimeTableModel> timeTableModelList =  this.peizhengHtmlResolver.resolveClassDetail(html,teacherName,weekNo);
            if(this.timeTableModelMap.size()>500){
                for(String key:this.timeTableModelMap.keySet()){
                    this.timeTableModelMap.remove(key);
                    break;
                }

            }
            this.timeTableModelMap.put(dataSend.getTeacherName(),timeTableModelList);
            return timeTableModelList;
        }
        return timeTableModels;


    }

    public List<Teacher> getAllTeacher(){
        return new ArrayList<Teacher>(this.teacherMap.values());
    }



}
