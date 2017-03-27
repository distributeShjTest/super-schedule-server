package com.su.schedule.business.write.dao;

import com.su.schedule.business.read.dao.TeacherReadDao;
import com.su.schedule.model.po.Department;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/3/28.
 */
public class DepartmentWriteDaoTestCase extends TestCase{

    private DepartmentWriteDao departmentWriteDao;

    public DepartmentWriteDaoTestCase(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
        this.departmentWriteDao = (DepartmentWriteDao) applicationContext.getBean("departmentWriteDaoImpl");
    }

    public void testInsertDepartment(){
        try {
            Department department = new Department();
            department.setName("勘探");
            System.out.println(this.departmentWriteDao.insertDepartment(department));;
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }


    }
}
