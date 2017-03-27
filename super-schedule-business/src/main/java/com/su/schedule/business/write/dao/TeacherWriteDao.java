package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Teacher;

/**
 * Created by shj on 2017/3/27.
 */
public interface TeacherWriteDao {
    Integer insertTeacher(Teacher teacher)throws Exception;
}
