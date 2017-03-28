package com.su.schedule.business.write.manage;

import com.su.schedule.model.po.Teacher;

/**
 * Created by shj on 2017/3/28.
 */
public interface TeacherWriteManage {

    Integer insertTeacherReturnId(Teacher teacher)throws Exception;
}
