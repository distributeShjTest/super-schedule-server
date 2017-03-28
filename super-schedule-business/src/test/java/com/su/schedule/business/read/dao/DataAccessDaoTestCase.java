package com.su.schedule.business.read.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.schedule.model.dto.DataSend;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DataAccessDaoTestCase extends TestCase {
	private DataAccessReadDao dataAccessReadDao;
	
	public DataAccessDaoTestCase(){
		System.setProperty("global.config.path","E:\\git\\mygit\\envConfig\\env-dev");
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
	        this.dataAccessReadDao = (DataAccessReadDao) applicationContext.getBean("dataAccessReadDaoImpl");
	}
	
	public void testQueryForCombine(){
		DataSend dataSend = new DataSend();
		dataSend.setCourseName("油气田开发地质学");
		try {
			System.out.println(this.dataAccessReadDao.queryForCombine(dataSend));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
