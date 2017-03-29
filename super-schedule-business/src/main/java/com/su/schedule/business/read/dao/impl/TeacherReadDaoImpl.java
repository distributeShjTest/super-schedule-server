package com.su.schedule.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.read.dao.TeacherReadDao;
import com.su.schedule.model.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 2017/3/27.
 */
@Repository
public class TeacherReadDaoImpl implements TeacherReadDao {

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;



    public List<Teacher> queryForName(Integer schoolId ,List<String> list) throws Exception {
        return sqlMapClient.queryForList("teacher_sql_map.query_for_name",list);
    }

    public List<String> queryForAllNames() throws Exception {
        return sqlMapClient.queryForList("teacher_sql_map.query_for_all_names");
    }
}
