package com.su.schedule.business.read.manage.impl;

import com.su.schedule.business.read.dao.DataAccessReadDao;
import com.su.schedule.business.read.manage.DataAccessReadManage;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.po.DataAccess;
import com.su.schedule.model.vo.TimeTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
@Service
public class DataAccessReadManageImpl implements DataAccessReadManage{

    @Autowired
    private DataAccessReadDao dataAccessReadDao;

    public List<TimeTableModel> getTimeTableModels(DataSend dataSend) throws Exception {
        List<DataAccess> dataAccesses = this.dataAccessReadDao.queryForCombine(dataSend);
        List<TimeTableModel> res = new ArrayList<TimeTableModel>();



        return res;

    }
}
