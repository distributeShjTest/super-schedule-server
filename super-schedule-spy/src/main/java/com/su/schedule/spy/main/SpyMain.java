package com.su.schedule.spy.main;

import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.spy.handler.impl.CsuHandler;
import com.su.schedule.spy.resolver.impl.CsuHtmlResolver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
@Component
public class SpyMain {

    @Autowired
    private CsuHandler htmlHandler;

    @Autowired
    private CsuHtmlResolver htmlResolver;
    private static final long sleepMills = 2678400000l;

    private static Logger logger = Logger.getLogger(SpyMain.class);
    @PostConstruct
    public void init(){
        new Thread(){

            @Override
            public void run() {
                while (true){
                    try {
                        int pageNum = 0;
                        while (!htmlResolver.isEnd()){
                            List<ClassDetail> classDetails = htmlResolver.resolve(pageNum);
                            htmlHandler.handleRosolver(classDetails);
                            pageNum++;
                        }
                    }catch (Exception e){
                        logger.error(e.getMessage());
                    }finally {
                        try {
                            Thread.sleep(sleepMills);
                        }catch (Exception e){

                            logger.equals(e.getMessage());
                        }
                    }

                }
            }
        }.start();

    }


}
