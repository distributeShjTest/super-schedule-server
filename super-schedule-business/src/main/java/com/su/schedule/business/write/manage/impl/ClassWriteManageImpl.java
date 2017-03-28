package com.su.schedule.business.write.manage.impl;

import com.su.schedule.business.write.dao.ClassWriteDao;
import com.su.schedule.business.write.manage.ClassWriteManage;
import com.su.schedule.model.po.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class ClassWriteManageImpl implements ClassWriteManage {
    @Autowired
    private ClassWriteDao classWriteDao;

    public Integer insertClassReturnId(Class cl) throws Exception {
        return null;
    }
}
