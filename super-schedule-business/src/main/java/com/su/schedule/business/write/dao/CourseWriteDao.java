package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Course;

public interface CourseWriteDao {
	Integer insertCourse(Course course)throws Exception;
}
