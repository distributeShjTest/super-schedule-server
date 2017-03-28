package com.su.schedule.business.write.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.schedule.model.po.CRRel;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CRRelWriteDaoTestCase extends TestCase {
	private CRRelWriteDao cRRelWriteDao;
	
	public CRRelWriteDaoTestCase(){
		System.setProperty("global.config.path", "E:\\git\\mygit\\envConfig\\env-dev");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:super-schedule-business/spring-service.xml");
		this.cRRelWriteDao = (CRRelWriteDao) applicationContext.getBean("CRRelWriteDaoImpl");
	}
	public void testInsertCRRel(){
		CRRel crRel = new CRRel();
		crRel.setClassId(1);
		crRel.setRelationId(1);
		try {
			this.cRRelWriteDao.insertCRRel(crRel);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
