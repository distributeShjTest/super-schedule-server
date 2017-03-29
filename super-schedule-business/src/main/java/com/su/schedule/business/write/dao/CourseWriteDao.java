package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Course;

/**
 * @author:lph on 2017年3月28日
 */
public interface CourseWriteDao {
	Integer insertCourse(Course course)throws Exception;
}
