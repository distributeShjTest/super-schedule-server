package com.su.schedule.business.write.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.schedule.business.write.ClassWriteDao;

import junit.framework.TestCase;

public class ClassWriteDaoTestCase extends TestCase {
	private ClassWriteDao classWriteDao;
	
	public ClassWriteDaoTestCase(){
		System.setProperty("global.config.path", "E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.classWriteDao = (ClassWriteDao) applicationContext.getBean("classWriteDaoImpl");
	}
	public void testInsertClass(){
		List<Class> classes = new ArrayList<Class>();
		Class clas = new Class(null,"Hardon");
		classes.add(clas);
		this.classWriteDao.insertClass(classes);
		Assert.fail();
	}
}
