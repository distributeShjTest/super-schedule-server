package com.su.schedule.business.read.dao;

import com.su.schedule.model.po.Class;

import java.util.List;

public interface ClassReadDao {
	List<Class> queryBufferClass(List<String> classNames)throws Exception;
}
