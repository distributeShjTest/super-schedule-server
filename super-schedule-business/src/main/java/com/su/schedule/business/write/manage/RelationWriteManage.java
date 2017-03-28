package com.su.schedule.business.write.manage;

import com.su.schedule.model.po.Relation;

/**
 * Created by shj on 2017/3/28.
 */
public interface RelationWriteManage {

    public Integer insertRelationReturnId(Relation relation)throws Exception;
}
