package com.su.schedule.business.write.dao;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import com.su.schedule.model.po.Class;

public class ClassWriteDaoTestCase extends TestCase {
	private ClassWriteDao classWriteDao;
	
	public ClassWriteDaoTestCase(){
		System.setProperty("global.config.path", "E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.classWriteDao = (ClassWriteDao) applicationContext.getBean("classWriteDaoImpl");
	}
	
	public void testInsertClass(){
		Class cls = new Class();
		cls.setName("joe");
		try {
			System.out.println(this.classWriteDao.insertClass(cls));
		} catch (Exception e) {
			e.printStackTrace();
			 Assert.fail();
		}
	}
}
