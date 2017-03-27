package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Department;
import com.su.schedule.model.po.Teacher;

/**
 * Created by shj on 2017/3/27.
 */
public interface DepartmentWriteDao {

    Integer  insertDepartment(Department department)throws Exception;
}
