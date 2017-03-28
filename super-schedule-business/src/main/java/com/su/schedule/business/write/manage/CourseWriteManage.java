package com.su.schedule.business.write.manage;

import com.su.schedule.model.po.Course;

/**
 * Created by shj on 2017/3/28.
 */
public interface CourseWriteManage {
    Integer insertCourseReturnId(Course course)throws Exception;
}
