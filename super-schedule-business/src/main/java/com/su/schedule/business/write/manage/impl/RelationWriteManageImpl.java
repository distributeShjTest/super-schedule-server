package com.su.schedule.business.write.manage.impl;

import com.su.schedule.business.write.dao.RelationWriteDao;
import com.su.schedule.business.write.manage.RelationWriteManage;
import com.su.schedule.model.po.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 2017/3/28.
 */
@Service
public class RelationWriteManageImpl implements RelationWriteManage {

    @Autowired
    private RelationWriteDao relationWriteDao;

    public Integer insertRelationReturnId(Relation relation) throws Exception {
        return this.relationWriteDao.insertRelation(relation);
    }
}
