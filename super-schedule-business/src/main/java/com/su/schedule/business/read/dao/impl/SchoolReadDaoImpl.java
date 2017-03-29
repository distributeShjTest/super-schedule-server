package com.su.schedule.business.read.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.read.dao.SchoolReadDao;

/**
*@author:lph on 2017年3月29日
*/
@Repository
public class SchoolReadDaoImpl implements SchoolReadDao{
	@Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMap;
	public Integer qureyForId(Integer schoolId ,String name) throws Exception {
		Map map = new HashMap();
        map.put("name",name);
        return (Integer) sqlMap.queryForObject("school_sql_map.query_for_id",name);
	}
	
}
