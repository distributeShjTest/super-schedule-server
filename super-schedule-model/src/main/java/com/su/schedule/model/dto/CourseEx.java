package com.su.schedule.model.dto;

import com.su.schedule.model.po.Course;

/**
 * Created by shj on 2017/3/28.
 */
public class CourseEx extends Course{
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
