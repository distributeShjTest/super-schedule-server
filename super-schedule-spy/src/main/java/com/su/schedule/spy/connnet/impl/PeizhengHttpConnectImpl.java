package com.su.schedule.spy.connnet.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.ValidateHeader;
import com.su.schedule.spy.connnet.HttpConnect;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by shj on 2017/3/29.
 */
@Component(value = "peizhengHttpConnect")
public class PeizhengHttpConnectImpl extends HttpConnect {


    @PostConstruct
    @Override
    public void init() {
        this.cookieStore = new BasicCookieStore();
        this.httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }


    @Override
    public byte[] getValidate() throws Exception{
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(Constant.PEI_ZHENG_VALIDATE_URL);
        for(ValidateHeader v:ValidateHeader.values()){
            httpGet.addHeader(v.getName(),v.getValue());
        }
        this.addCoockies(httpGet);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        InputStream inValidate = httpResponse.getEntity().getContent();
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inValidate.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] bytes = swapStream.toByteArray();
        return bytes;
    }

    @Override
    public HttpGet httpGetSimulate(HttpGet httpGet) throws Exception {
        for(ValidateHeader v:ValidateHeader.values()){
            httpGet.addHeader(v.getName(),v.getValue());
        }
        this.addCoockies(httpGet);
        return httpGet;
    }
}
