package com.su.schedule.business.read.dao;

import com.su.schedule.model.po.Department;

import java.util.List;

/**
 * Created by shj on 2017/3/27.
 */
public interface DepartmentReadDao {
    public List<Department> queryForNoAndName(List<String> departmentNames)throws Exception;

}
