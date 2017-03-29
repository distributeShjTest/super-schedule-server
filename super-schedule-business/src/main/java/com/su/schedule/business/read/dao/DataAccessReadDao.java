package com.su.schedule.business.read.dao;

import java.util.List;

import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.po.DataAccess;

/**
 * @author:lph on 2017年3月28日
 */
public interface DataAccessReadDao {
	
	List<DataAccess> queryForCombine(Integer schoolId ,DataSend dataSend)throws Exception;
}
