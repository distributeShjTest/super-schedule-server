package com.su.schedule.business.read.manage.impl;

import com.su.schedule.business.read.dao.DepartmentReadDao;
import com.su.schedule.business.read.manage.DepartmentReadManage;
import com.su.schedule.model.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class DepartmentReadManageImpl implements DepartmentReadManage{

    @Autowired
    private DepartmentReadDao departmentReadDao;

    public List<Department> getDepartmentsByNames(List<String> departmentNames) throws Exception {
        return this.departmentReadDao.queryForNoAndName(departmentNames);
    }
}
