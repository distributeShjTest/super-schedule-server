import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.spy.connnet.impl.CsuHttpConnectImpl;
import com.su.schedule.spy.connnet.impl.CsuPageParamHeaderSimulate;
import com.su.schedule.spy.resolver.HtmlResolver;
import com.su.schedule.spy.resolver.impl.CsuHtmlResolver;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by shj on 2017/3/27.
 */
public class HttpReSolverTestCase extends TestCase{

    public void testInsertClassDetail(){
        ClassDetail classDetail = new ClassDetail();
        CsuHtmlResolver htmlResolver = new CsuHtmlResolver();
        try {
            htmlResolver.insertClassDetail(classDetail,0,"lesson");
            htmlResolver.insertClassDetail(classDetail,1,"1");
            htmlResolver.insertClassDetail(classDetail,2,"shj");
            htmlResolver.insertClassDetail(classDetail,3,"prefe");
            htmlResolver.insertClassDetail(classDetail,10,"地勘1601,地勘1602");
            htmlResolver.insertClassDetail(classDetail,11,"weeks");
            htmlResolver.insertClassDetail(classDetail,12,"sections");
            htmlResolver.insertClassDetail(classDetail,13,"location");
            htmlResolver.insertClassDetail(classDetail,14,"department");
            System.out.println(classDetail);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testResolv(){
        try {
            CsuHttpConnectImpl httpConnect = new CsuHttpConnectImpl();
            httpConnect.init();
            CsuHtmlResolver htmlResolver = new CsuHtmlResolver();
            htmlResolver.setHttpConnect(httpConnect);
            CsuPageParamHeaderSimulate pageParamHeaderSimulate = new CsuPageParamHeaderSimulate();
            htmlResolver.setPageParamHeaderSimulate(pageParamHeaderSimulate);
            System.out.println(htmlResolver.resolve(1));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }


}
