package com.su.schedule.spy.handler;

import com.su.schedule.model.dto.ClassDetail;

import java.util.List;

/**
 * Created by shj on 2017/3/29.
 */
public interface HtmlHandler {
    void handleRosolver(List<ClassDetail> list)throws Exception;
}
