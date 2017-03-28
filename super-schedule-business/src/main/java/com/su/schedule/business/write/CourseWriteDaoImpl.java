package com.su.schedule.business.write;

import java.util.List;

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
	public void insertCourse(List<Course> courses) throws Exception {
		
	}
	
}
