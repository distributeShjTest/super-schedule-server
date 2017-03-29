package com.su.schedule.spy.handler.impl;

import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.vo.TimeTableModel;
import com.su.schedule.spy.handler.PeizhengHandler;

import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
public class PeizhengHandlerImpl implements PeizhengHandler{


    public boolean insertValidateCode(String code) throws Exception {
        return false;
    }

    public byte[] getValidatePic() throws Exception {
        return new byte[0];
    }

    public List<TimeTableModel> queryTimetable(DataSend dataSend) throws Exception {
        return null;
    }
}
