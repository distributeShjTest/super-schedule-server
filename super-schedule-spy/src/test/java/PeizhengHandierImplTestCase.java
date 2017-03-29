import com.su.schedule.spy.handler.impl.PeizhengHandlerImpl;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/3/30.
 */
public class PeizhengHandierImplTestCase extends TestCase {

    private PeizhengHandlerImpl peizhengHandler;

    public PeizhengHandierImplTestCase(){

        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-spy/spring-service.xml");
        this.peizhengHandler = (PeizhengHandlerImpl)applicationContext.getBean("PeizhengHandlerImpl");
    }


    public void testAll(){
        System.out.println(this.peizhengHandler.getAllTeacher());
    }

}
