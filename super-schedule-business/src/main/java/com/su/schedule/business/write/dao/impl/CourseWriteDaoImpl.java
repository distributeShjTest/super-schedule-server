package com.su.schedule.business.write.dao.impl;

import java.util.List;

import com.su.schedule.business.write.dao.CourseWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.model.po.Course;

@Repository
public class CourseWriteDaoImpl implements CourseWriteDao {
	@Autowired
	@Qualifier (value = "sqlMapClientWrite")
	private SqlMapClient sqlMap;
	public void insertCourse(List<Course> Courses) throws Exception {
		
	}
	
}
