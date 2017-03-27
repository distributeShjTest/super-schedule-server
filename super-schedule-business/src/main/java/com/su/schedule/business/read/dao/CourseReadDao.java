package com.su.schedule.business.read.dao;

import java.util.List;

import com.su.schedule.model.po.Course;

public interface CourseReadDao {
	List<Course> queryBufferCourse(int id)throws Exception;
}
