import junit.framework.TestCase;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.junit.Assert;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

/**
 * Created by shj on 2017/3/24.
 */
public class MainTest extends TestCase{


    public void testHttpSimulate(){
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpGet httpGet =new HttpGet("http://csujwc.its.csu.edu.cn");
        HttpGet httpGetforMainJsp = new HttpGet("http://csujwc.its.csu.edu.cn/kblogin.jsp?f=/jiaowu/tkgl/queryqxzbk.jsp");
        httpGetforMainJsp.addHeader("Connection","keep-alive");
        httpGetforMainJsp.addHeader("Upgrade-Insecure-Requests","1");
        httpGetforMainJsp.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGetforMainJsp.addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/602.4.8 (KHTML, like Gecko) Version/10.0.3 Safari/602.4.8");
        httpGetforMainJsp.addHeader("Referer","http://csujwc.its.csu.edu.cn/");
        httpGetforMainJsp.addHeader("Accept-Language","Accept-Language");
        httpGetforMainJsp.addHeader("Accept-Encoding","gzip, deflate");
//        HttpGet httpGetForRealJsp = new HttpGet("http://csujwc.its.csu.edu.cn/jiaowu/tkgl/queryqxzbk.jsp");
//        httpGetForRealJsp.addHeader("Connection","keep-alive");
//        httpGetForRealJsp.addHeader("Upgrade-Insecure-Requests","1");
//        httpGetForRealJsp.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//        httpGetForRealJsp.addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/602.4.8 (KHTML, like Gecko) Version/10.0.3 Safari/602.4.8");
//        httpGetForRealJsp.addHeader("Referer","http://csujwc.its.csu.edu.cn/");
//        httpGetForRealJsp.addHeader("Accept-Language","Accept-Language");
//        httpGetForRealJsp.addHeader("Accept-Encoding","gzip, deflate");
//        HttpGet httpGetDwr = new HttpGet("http://csujwc.its.csu.edu.cn/dwr/interface/dwrMonitor.js");

        HttpGet httpGetSqlInit = new HttpGet("http://csujwc.its.csu.edu.cn/tkglAction.do?method=qxzkb&sql=init");

//        httpGetSqlInit.addHeader("Referer","http://csujwc.its.csu.edu.cn/jiaowu/tkgl/queryqxzbk.jsp");
//        http://csujwc.its.csu.edu.cn/jiaowu/tkgl/queryqxzbk.jsp	200	GET	csujwc.its.csu.edu.cn	/jiaowu/tkgl/queryqxzbk.jsp	Sun Mar 26 00:31:47 CST 2017	125	16312	Complete
//        http://csujwc.its.csu.edu.cn/tkglAction.do?method=qxzkb&sql=init	200	GET	csujwc.its.csu.edu.cn	/tkglAction.do?method=qxzkb&sql=init	Sun Mar 26 00:31:47 CST 2017	154	8654	Complete
        try {
//            JSESSIONID=619327CC3E9E2A5BFE884DCFB43DDFAE; BIGipServerpool_jwctest=2034746826.20480.0000
//            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            CloseableHttpResponse httpResponseForMainJsp = httpClient.execute(httpGetforMainJsp);
//            Thread.sleep(5000);
//            CloseableHttpResponse httpResRealJsp = httpClient.execute(httpGetForRealJsp);
            String cookie = "";
//            for(int i=0;i<cookieStore.getCookies().size();i++){
//
//                cookie+=cookieStore.getCookies().get(cookieStore.getCookies().size()-i-1).getName()+"="+cookieStore.getCookies().get(cookieStore.getCookies().size()-i-1).getValue()+"; ";
////                System.out.println(c.getDomain());
////                System.out.println(c.getExpiryDate());
////                System.out.println(c.getPath());
////                System.out.println(c.getValue());
////                System.out.println(c.getName());
//            }
            for(Cookie c:cookieStore.getCookies()){
                cookie += c.getName()+"="+c.getValue()+"; ";
            }
            cookie = cookie.substring(0,cookie.length()-2);
            System.out.println(cookie);
            httpGetSqlInit.addHeader("Cookie",cookie);

            CloseableHttpResponse httpResSqlInit = HttpClients.createDefault().execute(httpGetSqlInit);
            for(Header h:httpResSqlInit.getAllHeaders()){
                System.out.println(h);
            }

            HttpEntity httpEntity = httpResSqlInit.getEntity();
            System.out.println(httpEntity.getContentLength());
            System.out.println(inputStream2String(httpEntity.getContent()));
//            System.out.println(com.su.schedule.spy.Constants.Header.values());
//<a href="/kblogin.jsp?f=/jiaowu/tkgl/queryqxzbk.jsp">全校性总课表</a>
        }catch (Exception e){
            e.printStackTrace();
        }






          

    }





    public static String inputStream2String(InputStream in){
        if(in==null)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        String temp = null;

//        int i;
        try {
//             System.out.println("read"+in.read());
            while ((temp=bufferedReader.readLine())!=null){
                stringBuilder.append(temp+"\n");

            }
//            while ((i=in.read())!=-1){
//                System.out.println(i);
//            }
        }catch (EOFException e){
            e.printStackTrace();
            return stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return stringBuilder.toString();

    }

    public void testReflection(){
        String a = "2";
        String b = "3";
        System.out.println(a.equals(null));
        System.out.println(Float.parseFloat("1"));
        System.out.println(Integer.parseInt("02"));
    }



}
