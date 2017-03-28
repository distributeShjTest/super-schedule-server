package com.su.schedule.business.read.dao;

import com.su.schedule.model.po.Teacher;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by shj on 2017/3/28.
 */
public class TeacherReadDaoTestCase extends TestCase{
    private TeacherReadDao teacherReadDao;

    public TeacherReadDaoTestCase(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
        this.teacherReadDao = (TeacherReadDao) applicationContext.getBean("teacherReadDaoImpl");
    }

    public void   testQueryForName(){
        try {
            System.out.println(this.teacherReadDao.queryForName(Arrays.asList(new String[]{"宋寒剑"})));;
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
