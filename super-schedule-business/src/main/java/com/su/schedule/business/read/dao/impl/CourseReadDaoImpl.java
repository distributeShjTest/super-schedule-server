package com.su.schedule.business.read.dao.impl;

import java.util.List;

import com.su.schedule.business.read.dao.CourseReadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.model.po.Course;

@Repository
public class CourseReadDaoImpl implements CourseReadDao {
	@Autowired
	@Qualifier(value = "sqlMapClientRead")
	private SqlMapClient sqlMap;

	public List<Course> queryForName(List<String> courseNames) throws Exception {
		return sqlMap.queryForList("course_sql_map.query_for_name", courseNames);
	}

}
