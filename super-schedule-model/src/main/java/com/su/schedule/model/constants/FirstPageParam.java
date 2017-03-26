package com.su.schedule.model.constants;

/**
 * Created by shj on 2017/3/26.
 */
public enum FirstPageParam {

    M("m",""),XNXQH("xnxqh","2016-2017-2"),XQID("xqid",""),JZWID("jzwid",""),GNQID("jzwid",""),JSID("jsid",""),
    JSMC("jsmc",""),KKYX("kkyx",""),JX02ID("jx02id",""),KCMC("kcmc",""),SKYX("skyx",""),SKNJ("sknj",""),
    SKZY("skzy",""),SKBJ("skbj",""),BJMC("bjmc",""),JG0101ID("jg0101id",""),JGXM("jgxm",""),
    ZC("zc",""),XQ("xq",""),JC("jc",""),JC1("jc1",""),FIND_TYPE("findType",""),TYPE2("type2","2");

    private String name;
    private String value;
    private FirstPageParam(String name,String value){
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
