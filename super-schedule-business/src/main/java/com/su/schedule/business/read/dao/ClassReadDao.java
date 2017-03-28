package com.su.schedule.business.read.dao;

import java.util.List;

public interface ClassReadDao {
	List<Class> queryBufferClass(List<String> classNames)throws Exception;
}
