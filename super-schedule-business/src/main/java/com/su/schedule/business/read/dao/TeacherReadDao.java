package com.su.schedule.business.read.dao;

import com.su.schedule.model.po.Teacher;

import java.util.List;

/**
 * Created by shj on 2017/3/27.
 */
public interface TeacherReadDao {
    List<Teacher> queryForName(Integer schoolId ,List<String> list)throws Exception;
    List<String> queryForAllNames()throws Exception;
}
