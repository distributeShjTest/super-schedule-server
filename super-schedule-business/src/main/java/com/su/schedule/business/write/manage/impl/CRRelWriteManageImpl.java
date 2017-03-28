package com.su.schedule.business.write.manage.impl;

import com.su.schedule.business.write.dao.CRRelWriteDao;
import com.su.schedule.business.write.manage.CRRelWriteManage;
import com.su.schedule.model.po.CRRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class CRRelWriteManageImpl implements CRRelWriteManage{

    @Autowired
    private CRRelWriteDao crRelWriteDao;


    public void insertCRRel(CRRel cRRel) throws Exception {
        this.crRelWriteDao.insertCRRel(cRRel);
    }
}
