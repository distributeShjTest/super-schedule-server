package com.su.schedule.business.read.dao;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

public class DataAccessDaoTestCase {
	private DataAccessReadDao dataAccessReadDao;
	
	public DataAccessDaoTestCase(){
		System.setProperty("global.config.path","E:\\git\\mygit\\envConfig\\env-dev");
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
	        this.dataAccessReadDao = (DataAccessReadDao) applicationContext.getBean("dataAccessReadDaoImpl");
	}
	
	public void testQueryForCombine(){
		try {
			System.out.println(this.dataAccessReadDao.queryForCombine(Arrays.asList(new String[]{"张术根"})));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
