package com.su.schedule.business.read.manage;

import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import com.su.schedule.model.vo.TimeTableModel;

import java.sql.Time;
import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
public interface DataAccessReadManage {

    public List<TimeTableModel> getTimeTableModels(DataSendExtend dataSend)throws Exception;
}
