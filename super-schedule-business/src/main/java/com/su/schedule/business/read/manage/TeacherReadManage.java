package com.su.schedule.business.read.manage;

import com.su.schedule.model.po.Teacher;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public interface TeacherReadManage {
    List<Teacher> getTeacherByNames(List<String> teacherNames)throws Exception;
    List<String> getAllTeacherNames()throws Exception;
}
