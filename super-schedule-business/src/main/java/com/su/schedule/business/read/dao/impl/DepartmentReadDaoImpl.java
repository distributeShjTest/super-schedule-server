package com.su.schedule.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.read.dao.DepartmentReadDao;
import com.su.schedule.model.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 2017/3/27.
 */
@Repository
public class DepartmentReadDaoImpl implements DepartmentReadDao {

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;


    public List<Department> queryForNoAndName(Integer schoolId ,List<String> departmentNames) throws Exception {
        return this.sqlMapClient.queryForList("department_sql_map.query_for_name",departmentNames);
    }
}
