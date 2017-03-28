package com.su.schedule.model.dto;

/**
 * Created by shj on 2017/3/29.
 */
public class DataSendExtend extends DataSend {
    private Integer weekNum;

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    @Override
    public String toString() {
        return "DataSendExtend{" +
                "weekNum=" + weekNum+
                '}'+super.toString();
    }
}
