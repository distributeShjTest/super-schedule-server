package com.su.schedule.business.read.dao;

import com.su.schedule.model.po.Class;

import java.util.List;

/**
 * @author:lph on 2017年3月28日
 */
public interface ClassReadDao {
	List<Class> queryForName(Integer schoolId ,List<String> classNames) throws Exception;
}
