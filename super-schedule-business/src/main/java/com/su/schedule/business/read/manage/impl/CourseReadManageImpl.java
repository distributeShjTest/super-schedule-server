package com.su.schedule.business.read.manage.impl;

import com.su.schedule.business.read.dao.CourseReadDao;
import com.su.schedule.business.read.manage.CourseReadManage;
import com.su.schedule.model.po.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class CourseReadManageImpl implements CourseReadManage{


    @Autowired
    private CourseReadDao courseReadDao;
    public List<Course> getCoursesByNames(List<String> courseNames,Integer schoolId) throws Exception {
        return this.courseReadDao.queryForName(courseNames);
    }

    public List<String> getAllCourseNames(Integer schoolId) throws Exception {
        return this.courseReadDao.quryForAllNames(schoolId);
    }
}
