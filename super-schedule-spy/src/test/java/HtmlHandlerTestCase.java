import com.su.schedule.business.write.dao.RelationWriteDao;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.po.Class;
import com.su.schedule.model.po.Relation;
import com.su.schedule.spy.connnet.impl.HttpConnect;
import com.su.schedule.spy.handler.HtmlHandler;
import com.su.schedule.spy.resolver.HtmlResolver;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public class HtmlHandlerTestCase extends TestCase{
    private HttpConnect httpConnect;
    private HtmlHandler htmlHandler;
    private HtmlResolver htmlResolver;
    public HtmlHandlerTestCase(){

        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-spy/spring-service.xml");
        this.htmlHandler = (HtmlHandler) applicationContext.getBean("htmlHandler");
        this.htmlResolver = (HtmlResolver)applicationContext.getBean("htmlResolver");
        this.httpConnect = (HttpConnect)applicationContext.getBean("httpConnect");
    }

    public void testHandleRosolver(){
        try {
            List<ClassDetail> classDetails = this.htmlResolver.resolve(1);
            this.htmlHandler.handleRosolver(classDetails);
            List<ClassDetail> classDetails1 = this.htmlResolver.resolve(2);
            this.htmlHandler.handleRosolver(classDetails1);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }


    }

    public void testSectionHandle(){
        try {
            this.htmlHandler.sectionHandle("10910",new Relation());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }


}
