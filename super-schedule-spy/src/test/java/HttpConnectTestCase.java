import com.su.schedule.spy.connnet.impl.HttpConnect;
import com.su.schedule.spy.connnet.impl.PageParamHeaderSimulate;
import junit.framework.TestCase;
import org.apache.http.HttpEntity;
import org.junit.Assert;

/**
 * Created by shj on 2017/3/26.
 */
public class HttpConnectTestCase extends TestCase {

    private HttpConnect httpConnect;

    public HttpConnectTestCase(){
        this.httpConnect = new HttpConnect();
        this.httpConnect.init();

    }

    public void testExecuteRequest(){
        try {
            this.httpConnect.getCookie();
            System.out.println(this.httpConnect.executeRequest(this.httpConnect.httpPostSimulate(PageParamHeaderSimulate.getFirstPageRequest()),true));
            System.out.println(this.httpConnect.executeRequest(this.httpConnect.httpPostSimulate(PageParamHeaderSimulate.getOtherPageRequest(2)),true));

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }

    }
}
