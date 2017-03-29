package com.su.schedule.business.read.dao;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ClassReadDaoTestCase extends TestCase {
	private ClassReadDao classReadDao;
	public ClassReadDaoTestCase(){
		System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.classReadDao = (ClassReadDao) applicationContext.getBean("classReadDaoImpl");
	}
	
	public void testQueryForName(){
		try {
			System.out.println(this.classReadDao.queryForName(Arrays.asList(new String[]{"城规1501","地物1601"})));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
