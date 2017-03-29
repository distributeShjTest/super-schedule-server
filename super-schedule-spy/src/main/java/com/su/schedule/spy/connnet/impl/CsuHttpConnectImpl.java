package com.su.schedule.spy.connnet.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.Header;
import com.su.schedule.model.constants.PageHeader;
import com.su.schedule.spy.connnet.HttpConnect;
import junit.framework.TestCase;
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
import java.io.InputStreamReader;

/**
 * Created by shj on 2017/3/26.
 */
@Component(value = "csuHttpConnect")
public class CsuHttpConnectImpl extends HttpConnect{




    @PostConstruct
    public void init(){
        this.cookieStore = new BasicCookieStore();
        this.httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }

    @Override
    public byte[] getValidate() {
        return null;
    }
}
