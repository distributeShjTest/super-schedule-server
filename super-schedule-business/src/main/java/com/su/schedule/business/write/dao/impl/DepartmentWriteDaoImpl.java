package com.su.schedule.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.write.dao.DepartmentWriteDao;
import com.su.schedule.model.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/3/27.
 */
@Repository
public class DepartmentWriteDaoImpl implements DepartmentWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;


    public Integer insertDepartment(Department department) throws Exception {
        return (Integer) this.sqlMapClient.insert("department_sql_map.insert_department",department);
    }
}
