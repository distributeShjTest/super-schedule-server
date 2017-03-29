package com.su.schedule.spy.connnet;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.Header;
import com.su.schedule.model.constants.PageHeader;
import com.sun.tools.javac.code.Attribute;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.HttpClients;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
public abstract class HttpConnect {
    protected CookieStore cookieStore;
    protected HttpClient httpClient;
    protected String validateCode;

    public abstract void init();

    public abstract byte[] getValidate() throws Exception;
    public HttpGet httpGetSimulate(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        for (Header h:Header.values()){
            httpGet.addHeader(h.getName(),h.getValue());
        }
        this.addCoockies(httpGet);

        return httpGet;
    }



    public HttpGet httpGetSimulate(HttpGet httpGet) throws Exception {
        for(Header h:Header.values()){
            httpGet.addHeader(h.getName(),h.getValue());
        }
        this.addCoockies(httpGet);
        return httpGet;
    }

    public HttpPost httpPostSimulate(HttpPost httpPost) throws Exception {
        for(Header h:Header.values()){
            httpPost.addHeader(h.getName(),h.getValue());
        }
        this.addCoockies(httpPost);
        return httpPost;
    }

    public HttpPost httpPostSimulate(String url) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        for(Header h:Header.values()){
            httpPost.addHeader(h.getName(),h.getValue());
        }
        this.addCoockies(httpPost);
        return httpPost;
    }

    public String executeRequest(HttpRequestBase httpRequestBase, boolean isNewClient) throws Exception {
        HttpResponse httpResponse;
        if(isNewClient){
            httpResponse = HttpClients.createDefault().execute(httpRequestBase);
        }else {
            httpResponse = this.httpClient.execute(httpRequestBase);
        }
        String res = "";
        String temp =null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        while ((temp=bufferedReader.readLine())!=null){
            res +=temp+"\n";
        }
        return res;
    }
    public void addCoockies(HttpRequestBase httpRequestBase) throws Exception {
        String cookieString = "";
        if(CollectionUtils.isEmpty(cookieStore.getCookies()))
            this.getCookie();
        for(Cookie c:cookieStore.getCookies()){
            cookieString += c.getName()+"="+c.getValue()+"; ";
        }
        if(cookieStore.getCookies().size()>0)
            cookieString = cookieString.substring(0,cookieString.length()-2);
        httpRequestBase.addHeader(Constant.COOKIE,cookieString);
    }

    public void getCookie() throws Exception {
        HttpGet httpGet = new HttpGet(Constant.SESSSION_GET_URL);
        for (Header h:Header.values()){
            httpGet.addHeader(h.getName(),h.getValue());
        }

        this.httpClient.execute(httpGet);
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
