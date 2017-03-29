package com.su.schedule.business.read.manage;

import com.su.schedule.business.read.dao.DataAccessReadDao;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/3/29.
 */
public class DataAccessReadManageTestCase extends TestCase {
    private DataAccessReadManage dataAccessReadManage;

    public DataAccessReadManageTestCase(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-business/spring-service.xml");
        this.dataAccessReadManage = (DataAccessReadManage) applicationContext.getBean("dataAccessReadManageImpl");
    }

    public void testGetTimeTableModels(){
        DataSendExtend dataSendExtend = new DataSendExtend();
        dataSendExtend.setWeekNum(10);
        dataSendExtend.setCourseName("油气田开发地质学");
        try {
            System.out.println(this.dataAccessReadManage.getTimeTableModels(dataSendExtend));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }


}
