package com.su.schedule.business.read.dao;

import java.util.List;

import com.su.schedule.model.po.Course;

public interface CourseReadDao {
	List<Course> queryForName(List<String> courseNames)throws Exception;
	List<String> quryForAllNames()throws Exception;
}
