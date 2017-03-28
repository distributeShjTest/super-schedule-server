package com.su.schedule.business.write.manage;

import com.su.schedule.model.po.Department;

/**
 * Created by shj on 2017/3/28.
 */
public interface DepartmentWriteManage {

    Integer insertDepartmentReturnId(Department department)throws Exception;
}
