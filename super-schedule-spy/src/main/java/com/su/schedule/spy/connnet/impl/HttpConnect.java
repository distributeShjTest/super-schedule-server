package com.su.schedule.spy.connnet.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.Header;
import com.su.schedule.model.constants.PageHeader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shj on 2017/3/26.
 */
@Component
public class HttpConnect {

    private CloseableHttpClient httpClient;
    private CookieStore cookieStore;

    @PostConstruct
    public void init(){
        this.cookieStore = new BasicCookieStore();
        this.httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }

    public void getCookie() throws IOException{
        this.httpClient.execute(this.httpGetSimulate(Constant.SESSSION_GET_URL));
    }



    public String executeRequest(HttpRequestBase httpRequestBase)throws Exception{
        HttpResponse httpResponse = this.httpClient.execute(httpRequestBase);
        String res = "";
        String temp =null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        while ((temp=bufferedReader.readLine())!=null){
            res +=temp+"\n";
        }
        return res;

    }

    public HttpGet httpGetSimulate(String url){
        HttpGet httpGet = new HttpGet(url);
        for (Header h:Header.values()){
            httpGet.addHeader(h.getName(),h.getValue());
        }
        this.addCoockies(httpGet);

        return httpGet;
    }

    public HttpPost httpPostSimulate(String url){
        return null;
    }

    public HttpPost httpPostSimulate(HttpPost httpPost){
        for(PageHeader h:PageHeader.values()){
            httpPost.addHeader(h.getName(),h.getValue());
        }
        this.addCoockies(httpPost);
        return httpPost;
    }


    public void addCoockies(HttpRequestBase httpRequestBase){

        String cookieString = "";
        for(Cookie c:cookieStore.getCookies()){
            cookieString += c.getName()+"="+c.getValue()+"; ";
        }
        if(cookieStore.getCookies().size()>0)
        cookieString = cookieString.substring(0,cookieString.length()-2);
        httpRequestBase.addHeader(Constant.COOKIE,cookieString);
    }














}
