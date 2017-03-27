package com.su.schedule.business.read;

import java.util.List;

public interface ClassReadDao {
	List<Class> queryBufferClass(int id)throws Exception;
}
