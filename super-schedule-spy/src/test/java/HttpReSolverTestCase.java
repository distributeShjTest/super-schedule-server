import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.spy.connnet.impl.HttpConnect;
import com.su.schedule.spy.resolver.HtmlResolver;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by shj on 2017/3/27.
 */
public class HttpReSolverTestCase extends TestCase{

    public void testInsertClassDetail(){
        ClassDetail classDetail = new ClassDetail();
        try {
            HtmlResolver.insertClassDetail(classDetail,0,"lesson");
            HtmlResolver.insertClassDetail(classDetail,1,"1");
            HtmlResolver.insertClassDetail(classDetail,2,"shj");
            HtmlResolver.insertClassDetail(classDetail,3,"prefe");
            HtmlResolver.insertClassDetail(classDetail,10,"地勘1601,地勘1602");
            HtmlResolver.insertClassDetail(classDetail,11,"weeks");
            HtmlResolver.insertClassDetail(classDetail,12,"sections");
            HtmlResolver.insertClassDetail(classDetail,13,"location");
            HtmlResolver.insertClassDetail(classDetail,14,"department");
            System.out.println(classDetail);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testResolv(){
        try {
            HttpConnect httpConnect = new HttpConnect();
            httpConnect.init();
            HtmlResolver htmlResolver = new HtmlResolver();
            htmlResolver.setHttpConnect(httpConnect);
            System.out.println(htmlResolver.resolve(1));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }


}
