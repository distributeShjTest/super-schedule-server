import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.po.Relation;
import com.su.schedule.spy.connnet.impl.CsuHttpConnectImpl;
import com.su.schedule.spy.handler.impl.CsuHandler;
import com.su.schedule.spy.resolver.impl.CsuHtmlResolver;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public class HtmlHandlerTestCase extends TestCase{
    private CsuHttpConnectImpl httpConnect;
    private CsuHandler htmlHandler;
    private CsuHtmlResolver htmlResolver;
    public HtmlHandlerTestCase(){

        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-spy/spring-service.xml");
        this.htmlHandler = (CsuHandler) applicationContext.getBean("csuHandler");
        this.htmlResolver = (CsuHtmlResolver)applicationContext.getBean("csuHtmlReslver");
        this.httpConnect = (CsuHttpConnectImpl)applicationContext.getBean("csuHttpConnect");
    }

    public void testHandleRosolver(){
        try {
            List<ClassDetail> classDetails = this.htmlResolver.resolve(1);
            this.htmlHandler.handleRosolver(classDetails);
            List<ClassDetail> classDetails1 = this.htmlResolver.resolve(2);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails2 = this.htmlResolver.resolve(3);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails3 = this.htmlResolver.resolve(4);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails4 = this.htmlResolver.resolve(5);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails5 = this.htmlResolver.resolve(6);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails6 = this.htmlResolver.resolve(7);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails7 = this.htmlResolver.resolve(8);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails8 = this.htmlResolver.resolve(9);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails9 = this.htmlResolver.resolve(10);
            this.htmlHandler.handleRosolver(classDetails1);
            List<ClassDetail> classDetails10 = this.htmlResolver.resolve(11);
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
