package com.dreamplume.service.impl;

import com.dreamplume.dao.impl.UserDaoImpl;
import com.dreamplume.service.UserAffairDao;
import com.dreamplume.util.SpringUtil;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Classname UserAffairDaoImpl
 * @Description TODO
 * @Date 2021/3/18 14:55
 * @Created by 翊
 */
@Repository("userAffairDaoImpl")
@ContextConfiguration(classes = SpringUtil.class)
public class UserAffairDaoImpl implements UserAffairDao {

    @Resource(name = "userDaoImpl")
    UserDaoImpl userDao;

    public void transfer(String outUser, String inUser, int money) {
        userDao.outMoney(outUser, money);
        int i = 1/0;
        userDao.inMoney(inUser, money);
    }
}
