package com.su.schedule.business.read.manage;

import com.su.schedule.model.po.Department;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public interface DepartmentReadManage {


    List<Department> getDepartmentsByNames(List<String> departmentNames)throws Exception;
}
