package com.su.schedule.business.write.dao.impl;

import java.util.List;
import com.su.schedule.model.po.Class;

import com.su.schedule.business.write.dao.ClassWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author:lph on 2017年3月28日
 */
@Repository
public class ClassWriteDaoImpl implements ClassWriteDao {
	@Autowired
	@Qualifier (value = "sqlMapClientWrite")
	private SqlMapClient sqlMap;
	public Integer insertClass(Class cls) throws Exception {
		return (Integer) this.sqlMap.insert("class_sql_map.insert_class",cls);
	}

}
