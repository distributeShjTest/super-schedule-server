package com.su.schedule.business.read.manage.impl;

import com.su.schedule.business.read.dao.TeacherReadDao;
import com.su.schedule.business.read.manage.TeacherReadManage;
import com.su.schedule.model.po.School;
import com.su.schedule.model.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class TeacherReadManageImpl implements TeacherReadManage{

    @Autowired
    private TeacherReadDao teacherReadDao;

    public List<Teacher> getTeacherByNames(List<String> teacherNames,Integer schoolId) throws Exception {
        return this.teacherReadDao.queryForName(schoolId,teacherNames);
    }

    public List<String> getAllTeacherNames(Integer school) throws Exception {
        return this.teacherReadDao.queryForAllNames();
    }
}
