package com.su.schedule.business.write.dao.impl;

import java.util.List;

import com.su.schedule.business.write.dao.ClassWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ClassWriteDaoImpl implements ClassWriteDao {
	@Autowired
	@Qualifier (value = "sqlMapClientWrite")
	private SqlMapClient sqlMap;
	public void insertClass(List<Class> classes) throws Exception {
		
	}

}
