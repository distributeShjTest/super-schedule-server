package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Relation;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/3/28.
 */
public class RelationWriteDaoTestCase extends TestCase {

    private RelationWriteDao relationWriteDao;

    public RelationWriteDaoTestCase(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
        this.relationWriteDao = (RelationWriteDao) applicationContext.getBean("relationWriteDaoImpl");
    }


    public void testInsertRelation(){
        try {
            Relation relation = new Relation();
            relation.setBuildingName("B座409");
            relation.setCourseId(5);
            relation.setTeacherId(1);
            relation.setWeekNo(3);
            relation.setLessonNo("3-4");
            this.relationWriteDao.insertRelation(relation);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
}
