package com.su.schedule.spy.handler.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import com.su.schedule.model.vo.TimeTableModel;
import com.su.schedule.spy.connnet.impl.PeizhengHttpConnectImpl;
import com.su.schedule.spy.connnet.impl.PeizhengPageParamHeaderSimulate;
import com.su.schedule.spy.handler.PeizhengHandler;
import com.su.schedule.spy.resolver.impl.PeizhengHtmlResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public boolean insertValidateCode(String code) throws Exception {
        String html = this.peizhengHttpConnect.executeRequest(this.peizhengHttpConnect.httpPostSimulate(this.pageParamHeaderSimulate.getTimableQueryRequest(code, Constant.DEFAULT_TEST_TEACHER_ID)),true);
        List<ClassDetail> classDetails = this.peizhengHtmlResolver.resolveClassDetail(html);
        if(classDetails==null)
            return false;
        this.peizhengHttpConnect.setValidateCode(code);
        return true;
    }

    public byte[] getValidatePic() throws Exception {

        return this.peizhengHttpConnect.getValidate();
    }

    public List<TimeTableModel> queryTimetable(DataSendExtend dataSend) throws Exception {
        String teacherName = dataSend.getTeacherName();
        return null ;
    }


}
