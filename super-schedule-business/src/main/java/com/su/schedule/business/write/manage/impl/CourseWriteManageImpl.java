package com.su.schedule.business.write.manage.impl;

import com.su.schedule.business.write.dao.CourseWriteDao;
import com.su.schedule.business.write.manage.CourseWriteManage;
import com.su.schedule.model.po.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class CourseWriteManageImpl implements CourseWriteManage {

    @Autowired
    private CourseWriteDao courseWriteDao;

    public Integer insertCourseReturnId(Course course) throws Exception {
        return null;
    }
}
