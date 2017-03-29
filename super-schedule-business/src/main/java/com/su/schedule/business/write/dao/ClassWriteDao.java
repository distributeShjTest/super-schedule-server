package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Class;

/**
 * @author:lph on 2017年3月28日
 */
public interface ClassWriteDao {
	Integer insertClass(Class cls)throws Exception;
	
}
