package com.su.schedule.business.write.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.schedule.business.write.CourseWriteDao;
import com.su.schedule.model.po.Course;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CourseWriteDaoTestCase extends TestCase {
	private CourseWriteDao courseWriteDao;
	
	public CourseWriteDaoTestCase(){
		System.setProperty("global.config.path", "E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.courseWriteDao = (CourseWriteDao) applicationContext.getBean("classWriteDaoImpl");
	}
	public void testInsertCourse(){
		List<Course> courses = new ArrayList<Course>();
		Course course = new Course(null,"Joe","3-16","4",null);
		Course course1 = new Course(null,"Heisenberg","3-16","4",null);
		courses.add(course);
		courses.add(course1);
		try {
			this.courseWriteDao.insertCourse(courses);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
