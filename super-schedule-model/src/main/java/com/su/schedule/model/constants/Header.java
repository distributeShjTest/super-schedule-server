package com.su.schedule.model.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/3/26.
 */
public enum Header {

    HOST("Host","csujwc.its.csu.edu.cn"),ACCEPT("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    ACCEPT_ENCODING("Accept-Encoding","gzip, deflate"),ACCEPT_LANGUAGE("Accept-Language","zh-cn"),
    CONTENT_TYPE("Content-Type","application/x-www-form-urlencoded"),USER_AGENT("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/602.4.8 (KHTML, like Gecko) Version/10.0.3 Safari/602.4.8"),
    CONNECT("Connection","keep-alive"),UPGRADE_INSECURE_REQUESTS("Upgrade-Insecure-Requests","1"),
    ORIGIN("Origin","http://csujwc.its.csu.edu.cn");

    private String name;
    private String value;
    private Header(String name,String value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return this.name;
    }


    public String getValue(){
        return this.value;
    }

    public static List<Header> getAllHeader(){
        List<Header> headers = new ArrayList<Header>();
        headers.add(HOST);
        headers.add(ACCEPT);
        headers.add(ACCEPT_ENCODING);
        headers.add(ACCEPT_LANGUAGE);
        headers.add(CONTENT_TYPE);
        headers.add(UPGRADE_INSECURE_REQUESTS);
        headers.add(USER_AGENT);
        headers.add(CONNECT);
        return headers;
    }
}
