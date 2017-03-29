package com.su.schedule.spy.connnet;

import org.apache.http.client.methods.HttpPost;

/**
 * Created by shj on 2017/3/29.
 */
public interface PageParamHeaderSimulate {

    HttpPost getFirstPageRequest()throws Exception;
    HttpPost getOtherPageRequest(int pageNum)throws Exception;
}
