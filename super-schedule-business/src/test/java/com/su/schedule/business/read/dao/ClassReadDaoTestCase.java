package com.su.schedule.business.read.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ClassReadDaoTestCase extends TestCase {
	private ClassReadDao classReadDao;
	public ClassReadDaoTestCase(){
		System.setProperty("global.config.path","E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.classReadDao = (ClassReadDao) applicationContext.getBean("classReadDaoImpl");
	}
	
	public void testQueryBufferClass(){
		try {
			System.out.println(this.classReadDao.queryBufferClass(3));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
