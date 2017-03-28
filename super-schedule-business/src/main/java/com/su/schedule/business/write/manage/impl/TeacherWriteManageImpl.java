package com.su.schedule.business.write.manage.impl;

import com.su.schedule.business.write.dao.TeacherWriteDao;
import com.su.schedule.business.write.manage.TeacherWriteManage;
import com.su.schedule.model.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class TeacherWriteManageImpl implements TeacherWriteManage {

    @Autowired
    private TeacherWriteDao teacherWriteDao;

    public Integer insertTeacherReturnId(Teacher teacher) throws Exception {
        return this.teacherWriteDao.insertTeacher(teacher);
    }
}
