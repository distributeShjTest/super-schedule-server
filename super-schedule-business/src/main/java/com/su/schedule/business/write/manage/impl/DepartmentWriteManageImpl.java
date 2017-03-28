package com.su.schedule.business.write.manage.impl;

import com.su.schedule.business.write.dao.DepartmentWriteDao;
import com.su.schedule.business.write.manage.DepartmentWriteManage;
import com.su.schedule.model.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class DepartmentWriteManageImpl implements DepartmentWriteManage {
    @Autowired
    private DepartmentWriteDao departmentWriteDao;

    public Integer insertDepartmentReturnId(Department department) throws Exception {
        return this.departmentWriteDao.insertDepartment(department);
    }
}
