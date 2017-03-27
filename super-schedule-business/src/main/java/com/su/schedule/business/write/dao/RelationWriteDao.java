package com.su.schedule.business.write.dao;

import com.su.schedule.model.po.Relation;

/**
 * Created by shj on 2017/3/28.
 */
public interface RelationWriteDao {

    Integer insertRelation(Relation relation)throws Exception;
}
