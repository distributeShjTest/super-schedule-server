package com.su.schedule.business.read.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.read.dao.DataAccessReadDao;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.po.DataAccess;

@Repository
public class DataAccessReadDaoImpl implements DataAccessReadDao {
	@Autowired
	@Qualifier(value = "sqlMapClientRead")
	private SqlMapClient sqlMap;

	public List<DataAccess> queryForCombine(DataSend dataSend) throws Exception {
		return sqlMap.queryForList("dataAccess_sql_map.query_for_combine", dataSend);
	}

	
}
