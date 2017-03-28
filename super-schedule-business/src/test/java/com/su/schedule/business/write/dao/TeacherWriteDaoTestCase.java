package com.su.schedule.business.write.dao;

import com.su.schedule.business.read.dao.TeacherReadDao;
import com.su.schedule.model.po.Teacher;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/3/28.
 */
public class TeacherWriteDaoTestCase extends TestCase{

    private TeacherWriteDao teacherWriteDao;

    public TeacherWriteDaoTestCase(){
        System.setProperty("global.config.path","E:\\git\\mygit\\envConfig\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
        this.teacherWriteDao = (TeacherWriteDao) applicationContext.getBean("teacherWriteDaoImpl");
    }


    public void testInsertTeacher(){
        try {
            Teacher teacher = new Teacher();
            teacher.setName("宋寒剑");
            teacher.setLevel("副教授");
            System.out.println(this.teacherWriteDao.insertTeacher(teacher));;

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
}
