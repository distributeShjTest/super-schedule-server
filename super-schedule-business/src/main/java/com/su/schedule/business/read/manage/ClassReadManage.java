package com.su.schedule.business.read.manage;

import com.su.schedule.model.po.Class;

import java.util.List;

/**
 * Created by shj on 2017/3/28.
 */
public interface ClassReadManage {



    List<Class> getClassByNames(List<String> classNames)throws Exception;
}
