package com.su.schedule.business.read.dao;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CourseReadDaoTestCase extends TestCase {
	private CourseReadDao courseReadDao;
	public CourseReadDaoTestCase(){
		System.setProperty("global.config.path","E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.courseReadDao = (CourseReadDao) applicationContext.getBean("courseReadDaoImpl");
	}
	public void testQueryForName(){
		try {
			System.out.println(this.courseReadDao.queryForName(Arrays.asList(new String[]{"程序猿","计算机"})));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
