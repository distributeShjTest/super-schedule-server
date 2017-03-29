package com.su.schedule.business.read.dao;

import java.util.List;

import com.su.schedule.model.po.Course;

/**
 * @author:lph on 2017年3月28日
 */
public interface CourseReadDao {
	List<Course> queryForName(Integer schoolId ,List<String> courseNames)throws Exception;
	List<String> quryForAllNames()throws Exception;
}
