package com.su.schedule.business.read;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ClassReadDaoImpl implements ClassReadDao {
	@Autowired
	@Qualifier (value="sqlMapClientRead")
	private SqlMapClient sqlMap;
	public List<Class> queryBufferClass(int id) throws Exception {
		 return sqlMap.queryForList("class_sql_map.query_buffer_class",id);
	}
	
}
