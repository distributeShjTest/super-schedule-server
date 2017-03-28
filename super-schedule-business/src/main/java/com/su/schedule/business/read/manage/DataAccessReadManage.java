package com.su.schedule.business.read.manage;

import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.vo.TimeTableModel;

import java.sql.Time;
import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
public interface DataAccessReadManage {

    public List<TimeTableModel> getTimeTableModels(DataSend dataSend)throws Exception;
}
