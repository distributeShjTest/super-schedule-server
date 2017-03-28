package com.su.schedule.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.su.schedule.business.write.dao.CRRelWriteDao;
import com.su.schedule.model.po.CRRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/3/28.
 */
@Repository
public class CRRelWriteDaoImpl implements CRRelWriteDao{
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMap;

    public void insertCRRel(CRRel crRel) throws Exception {
        return;
    }
}
