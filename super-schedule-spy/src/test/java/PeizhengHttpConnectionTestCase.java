import com.su.schedule.model.constants.Constant;
import com.su.schedule.spy.connnet.HttpConnect;
import com.su.schedule.spy.connnet.impl.PeizhengHttpConnectImpl;
import com.su.schedule.spy.connnet.impl.PeizhengPageParamHeaderSimulate;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by shj on 2017/3/29.
 */
public class PeizhengHttpConnectionTestCase extends TestCase {

    private HttpConnect httpConnect;

    public PeizhengHttpConnectionTestCase(){
        this.httpConnect = new PeizhengHttpConnectImpl();
    }


    public static void main(String[] args) {

        HttpConnect httpConnect = new PeizhengHttpConnectImpl();
        PeizhengPageParamHeaderSimulate peizhengPageParamHeaderSimulate =new PeizhengPageParamHeaderSimulate();
        httpConnect.init();

        try {
            httpConnect.getCookie();
            byte[] buf = httpConnect.getValidate();
            BufferedOutputStream bos = null;
            FileOutputStream fos = null;
            File file = null;
            try
            {

                file = new File("validate.jpeg");
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos);
                bos.write(buf);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (bos != null)
                {
                    try
                    {
                        bos.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                if (fos != null)
                {
                    try
                    {
                        fos.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }



        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        in.close();
        try {
            System.out.println(httpConnect.executeRequest(httpConnect.httpPostSimulate(peizhengPageParamHeaderSimulate.getTimableQueryRequest(code, Constant.DEFAULT_TEST_TEACHER_ID)),true));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
