import com.su.schedule.spy.connnet.PageParamHeaderSimulate;
import com.su.schedule.spy.connnet.impl.CsuHttpConnectImpl;
import com.su.schedule.spy.connnet.impl.CsuPageParamHeaderSimulate;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by shj on 2017/3/26.
 */
public class HttpConnectTestCase extends TestCase {

    private CsuHttpConnectImpl httpConnect;

    public HttpConnectTestCase(){
        this.httpConnect = new CsuHttpConnectImpl();
        this.httpConnect.init();

    }

    public void testExecuteRequest(){
        try {
            this.httpConnect.getCookie();
            PageParamHeaderSimulate pageParamHeaderSimulate =new CsuPageParamHeaderSimulate();
            System.out.println(this.httpConnect.executeRequest(this.httpConnect.httpPostSimulate(pageParamHeaderSimulate.getFirstPageRequest()),true));
            System.out.println(this.httpConnect.executeRequest(this.httpConnect.httpPostSimulate(pageParamHeaderSimulate.getOtherPageRequest(2)),true));

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }

    }
}
