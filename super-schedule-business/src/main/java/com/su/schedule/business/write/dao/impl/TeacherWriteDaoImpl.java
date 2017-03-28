package com.su.schedule.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.write.dao.TeacherWriteDao;
import com.su.schedule.model.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/3/27.
 */
@Repository
public class TeacherWriteDaoImpl implements TeacherWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public Integer insertTeacher(Teacher teacher) throws Exception {
        return (Integer) this.sqlMapClient.insert("teacher_sql_map.insert_teacher",teacher);
    }
}
