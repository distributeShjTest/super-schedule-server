package com.su.schedule.business.read.dao.impl;

import java.util.List;

import com.su.schedule.business.read.dao.ClassReadDao;
import com.su.schedule.model.po.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author:lph on 2017年3月28日
 */
@Repository
public class ClassReadDaoImpl implements ClassReadDao {
	@Autowired
	@Qualifier (value="sqlMapClientRead")
	private SqlMapClient sqlMap;
	public List<Class> queryForName(Integer schoolId ,List<String> classNames) throws Exception {
		 return sqlMap.queryForList("class_sql_map.query_for_name",classNames);
	}
	
}
