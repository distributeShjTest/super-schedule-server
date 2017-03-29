package com.su.schedule.business.read.manage.impl;

import com.su.schedule.business.read.dao.ClassReadDao;
import com.su.schedule.business.read.manage.ClassReadManage;
import com.su.schedule.model.po.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class ClassReadManageImpl implements ClassReadManage {

    @Autowired
    private ClassReadDao classReadDao;

    public List<Class> getClassByNames(List<String> classNames,Integer school) throws Exception {
        return this.classReadDao.queryForName(school,classNames);
    }
}
