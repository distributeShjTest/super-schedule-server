package com.su.schedule.business.read.manage;

import com.su.schedule.model.po.Course;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public interface CourseReadManage {

    List<Course> getCoursesByNames(List<String> courseNames,Integer schoolId)throws Exception;
    List<String> getAllCourseNames(Integer schoolId)throws Exception;
}
