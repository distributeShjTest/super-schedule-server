package com.su.schedule.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.write.dao.RelationWriteDao;
import com.su.schedule.model.po.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/3/28.
 */
@Repository
public class RelationWriteDaoImpl implements RelationWriteDao{
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public Integer insertRelation(Relation relation) throws Exception {
        return (Integer) sqlMapClient.insert("relation_sql_map.insert_relation",relation);
    }
}
