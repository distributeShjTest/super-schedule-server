package com.su.schedule.business.read.dao;

import com.su.schedule.model.po.Department;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public class DepartmentReadDaoTestCase extends TestCase{

    private DepartmentReadDao departmentReadDao;

    public DepartmentReadDaoTestCase(){
        System.setProperty("global.config.path","E:\\git\\mygit\\envConfig\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
        this.departmentReadDao = (DepartmentReadDao) applicationContext.getBean("departmentReadDaoImpl");
    }


    public void testQueryForNoAndName(){
        try {
//            List<Department> list = new ArrayList<Department>();
//            Department department = new Department();
//            department.setName("勘探");
//            list.add(department);
            System.out.println(this.departmentReadDao.queryForNoAndName(Arrays.asList(new String[]{"勘探"})));
//            this.departmentReadDao.queryForNoAndName();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
