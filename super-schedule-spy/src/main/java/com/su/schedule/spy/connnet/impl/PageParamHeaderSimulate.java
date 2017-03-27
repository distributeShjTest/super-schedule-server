package com.su.schedule.spy.connnet.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.FirstPageParam;
import com.su.schedule.model.constants.OtherPageParam;
import com.su.schedule.model.constants.PageHeader;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/3/26.
 */
public class PageParamHeaderSimulate {

    public static HttpPost getFirstPageRequest()throws Exception{
        HttpPost httpPost = new HttpPost(Constant.PAGE_INFO_URL);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for(FirstPageParam f:FirstPageParam.values()){
            params.add(new BasicNameValuePair(f.getName(), f.getValue()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        httpPost.addHeader(PageHeader.FIRST_PAGE_REFERER.getName(),PageHeader.FIRST_PAGE_REFERER.getValue());

        return httpPost;
    }

    public static HttpPost getOtherPageRequest(int pageNum)throws Exception{
        HttpPost httpPost = new HttpPost(Constant.PAGE_INFO_URL);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for(OtherPageParam f:OtherPageParam.values()){
            params.add(new BasicNameValuePair(f.getName(), f.getValue()));
        }
        params.add(new BasicNameValuePair(Constant.PAGE_NUM,String.valueOf(pageNum)));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        httpPost.addHeader(PageHeader.OTHER_PAGE_REFERRER.getName(),PageHeader.OTHER_PAGE_REFERRER.getValue());

        return httpPost;
    }
}
