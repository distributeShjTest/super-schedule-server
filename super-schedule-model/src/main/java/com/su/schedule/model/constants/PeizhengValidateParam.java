package com.su.schedule.model.constants;

/**
 * Created by shj on 2017/3/29.
 */
public enum PeizhengValidateParam {
    SEL_XNXQ("Sel_XNXQ"),SEL_JS("Sel_JS"),TYPE("type"),TXT_YZM("txt_yzm");

    private String value;

    PeizhengValidateParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
