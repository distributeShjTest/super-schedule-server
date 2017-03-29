package com.su.schedule.model.constants;

/**
 * Created by shj on 2017/3/29.
 */
public enum ValidateHeader {
    ACCEPT("accept","*/*"),CONNECTION("Connection","keep-alive"),USER_AGENT("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/602.4.8 (KHTML, like Gecko) Version/10.0.3 Safari/602.4.8"),
    ACCEPT_LANGUAGE("Accept-Language","zh-cn"),REFERER("Referer","http://qg.peizheng.net.cn/ZNPK/TeacherKBFB.aspx"),
    ACCEPT_ENCODING("Accept-Encoding","gzip, deflate");


    private String name;
    private String value;
    private ValidateHeader(String name,String value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return this.name;
    }


    public String getValue(){
        return this.value;
    }
}
