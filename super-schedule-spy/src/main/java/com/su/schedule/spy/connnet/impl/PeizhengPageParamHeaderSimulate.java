package com.su.schedule.spy.connnet.impl;

import com.su.schedule.model.constants.Constant;
import com.su.schedule.model.constants.PeizhengValidateParam;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.spy.connnet.PageParamHeaderSimulate;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
@Component(value = "peizhengPageParamHeaderSimulate")
public class PeizhengPageParamHeaderSimulate implements PageParamHeaderSimulate {
    public HttpPost getFirstPageRequest() throws Exception {
        return null;
    }

    public HttpPost getOtherPageRequest(int pageNum) throws Exception {
        return null;
    }


    public HttpGet getTeacherPages()throws Exception{
        return new HttpGet(Constant.PEI_ZHENG_FIRST_PAGE_REQUEST);
    }

    public HttpPost getTimableQueryRequest(String valicode,String teacherId)throws Exception{
        HttpPost httpPost = new HttpPost(Constant.PEI_ZHENG_FIRST_PAGE_REQUEST);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair(PeizhengValidateParam.SEL_XNXQ.getValue(),Constant.QUERY_PERIOD));
        params.add(new BasicNameValuePair(PeizhengValidateParam.SEL_JS.getValue(),teacherId));
        params.add(new BasicNameValuePair(PeizhengValidateParam.TYPE.getValue(),Constant.QUERY_TYPE));
        params.add(new BasicNameValuePair(PeizhengValidateParam.TXT_YZM.getValue(),valicode));
        httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        return httpPost;
    }



}
