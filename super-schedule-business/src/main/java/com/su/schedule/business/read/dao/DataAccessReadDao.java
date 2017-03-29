package com.su.schedule.business.read.dao;

import java.util.List;

import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.po.DataAccess;

public interface DataAccessReadDao {
	
	List<DataAccess> queryForCombine(DataSend dataSend)throws Exception;
}
