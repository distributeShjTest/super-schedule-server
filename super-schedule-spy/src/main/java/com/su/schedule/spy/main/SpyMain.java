package com.su.schedule.spy.main;

import com.su.schedule.business.write.dao.RelationWriteDao;
import com.su.schedule.spy.handler.HtmlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by shj on 2017/3/28.
 */
@Component
public class SpyMain {

    @Autowired
    private HtmlHandler htmlHandler;



}
