package com.su.schedule.business.read.manage.impl;

import com.su.schedule.business.read.dao.DataAccessReadDao;
import com.su.schedule.business.read.manage.DataAccessReadManage;
import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import com.su.schedule.model.po.DataAccess;
import com.su.schedule.model.vo.TimeTableModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
@Service
public class DataAccessReadManageImpl implements DataAccessReadManage{

    @Autowired
    private DataAccessReadDao dataAccessReadDao;

    private static Logger logger = Logger.getLogger(DataAccessReadManageImpl.class);

    public List<TimeTableModel> getTimeTableModels(DataSendExtend dataSend,Integer schoolId) throws Exception {
        System.out.println(dataSend);
        if(dataSend.getWeekNum()==null)
            throw new Exception("weekNum count not be null");
        List<DataAccess> dataAccesses = this.dataAccessReadDao.queryForCombine(schoolId,dataSend);


        Integer weekNo = dataSend.getWeekNum();
        List<TimeTableModel> res = new ArrayList<TimeTableModel>();
        if(CollectionUtils.isEmpty(dataAccesses))
            return res;
        Integer finalTeacherId = dataAccesses.get(0).getTeacherId();
        Integer finalCourseId = dataAccesses.get(0).getCourseId();
        for(DataAccess d:dataAccesses){
//            if(finalCourseId!=d.getCourseId()||finalTeacherId!=d.getTeacherId())
//                continue;
            if(!isWeekExist(d,weekNo))
                continue;
            TimeTableModel timeTableModel = this.dataAccessTransfer(d);
            timeTableModel.setWeeknum(dataSend.getWeekNum()+"");
            res.add(timeTableModel);
        }



        return res;

    }

    private boolean isWeekExist(DataAccess dataAccess,Integer weekNo){
        String[] peroids = dataAccess.getPeriod().trim().split("-");
        if(peroids.length>3){
            logger.error("peroid problem,peroid is "+peroids);
            return false;
        }
        if(weekNo>Integer.parseInt(peroids[1])||weekNo<Integer.parseInt(peroids[0]))
            return false;
        if(peroids[2].equals(Constant.FULL_WEEK)){
            return true;
        }else {
            if((weekNo-Integer.parseInt(peroids[0]))%2==1)
                return false;
            return true;
        }
    }

    private TimeTableModel dataAccessTransfer(DataAccess dataAccess){
        System.out.println(dataAccess);
        TimeTableModel timeTableModel = new TimeTableModel();
        timeTableModel.setClassroom(dataAccess.getBuildingName());
        timeTableModel.setLessonname(dataAccess.getCourseName());
        timeTableModel.setWeek(dataAccess.getWeekNo());
        timeTableModel.setTeacher(dataAccess.getTeacherName());
        String[] lessonNo = dataAccess.getLessonNo().split("-");
        if(lessonNo.length==1){
            timeTableModel.setStartnum(Integer.parseInt(lessonNo[0]));
            timeTableModel.setEndnum(Integer.parseInt(lessonNo[0]));
        }else {
            timeTableModel.setStartnum(Integer.parseInt(lessonNo[0]));
            timeTableModel.setEndnum(Integer.parseInt(lessonNo[1]));
        }

        return timeTableModel;
    }



}
