package com.su.schedule.model.constants;

/**
 * Created by shj on 2017/3/26.
 */
public enum PageHeader {
    FIRST_PAGE_REFERER("Referer","http://csujwc.its.csu.edu.cn/jiaowu/tkgl/queryqxzbk.jsp"),OTHER_PAGE_REFERRER("Referer","http://csujwc.its.csu.edu.cn/tkglAction.do?method=qxzkb");


    private String name;
    private String value;
    private PageHeader(String name,String value){
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
