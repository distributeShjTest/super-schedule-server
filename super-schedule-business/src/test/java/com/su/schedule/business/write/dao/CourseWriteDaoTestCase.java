package com.su.schedule.business.write.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.schedule.model.po.Course;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CourseWriteDaoTestCase extends TestCase {
	private CourseWriteDao courseWriteDao;

	public CourseWriteDaoTestCase() {
		System.setProperty("global.config.path", "E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:super-schedule-business/spring-service.xml");
		this.courseWriteDao = (CourseWriteDao) applicationContext.getBean("courseWriteDaoImpl");
	}

	public void testInsertCourse() {
		Course course = new Course();
		course.setName("机器学习");
		course.setPeriod("3-16");
		course.setScore("4");
		course.setDepartmId(2);
		try {
			System.out.println(this.courseWriteDao.insertCourse(course));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
