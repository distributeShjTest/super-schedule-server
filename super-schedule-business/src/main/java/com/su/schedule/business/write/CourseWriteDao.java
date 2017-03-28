package com.su.schedule.business.write;

import java.util.List;

import com.su.schedule.model.po.Course;

public interface CourseWriteDao {
	void insertCourse(List<Course> courses)throws Exception;
}
