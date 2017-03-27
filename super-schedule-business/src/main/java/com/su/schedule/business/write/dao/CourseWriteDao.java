package com.su.schedule.business.write.dao;

import java.util.List;

import com.su.schedule.model.po.Course;

public interface CourseWriteDao {
	void insertCourse(List<Course> Courses)throws Exception;
}
