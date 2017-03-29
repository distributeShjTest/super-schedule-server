package com.su.schedule.spy.handler;

import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import com.su.schedule.model.vo.TimeTableModel;

import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
public interface PeizhengHandler {

     List<TimeTableModel> queryTimetable(DataSendExtend dataSend)throws Exception;

     byte[] getValidatePic()throws Exception;


     boolean insertValidateCode(String code)throws Exception;


}
