package com.su.schedule.business.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.model.po.Course;

@Repository
public class CourseReadDaoImpl implements CourseReadDao{
	@Autowired
	@Qualifier (value="sqlMapClientRead")
	private SqlMapClient sqlMap;
	public List<Course> queryBufferCourse(int id) throws Exception {
		 return sqlMap.queryForList("course_sql_map.query_buffer_course",id);
	}
	
}
