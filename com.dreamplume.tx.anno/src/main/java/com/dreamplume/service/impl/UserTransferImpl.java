package com.dreamplume.service.impl;

import com.dreamplume.dao.impl.UserDaoImpl;
import com.dreamplume.service.UserTransfer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * @Classname UserTranceImpl
 * @Description TODO
 * @Date 2021/3/18 10:26
 * @Created by 翊
 */
@Service("userTransferImpl")
// 可以在在类上面写入 @Transactional 事务注解，表明此整个类中的方法是一整个事务
public class UserTransferImpl implements UserTransfer {

    @Resource(name = "userDaoImpl")
    UserDaoImpl userDao;

    // 方法上面写入 @Transactional 事务的注解，表明此方法中的所有操作为一个事务
    @Transactional  // 注解此为一个事务
    public void transfer(String inUser, String outUSer, int money) {
        userDao.outMoney(outUSer, money);
        int i = 1/0;
        userDao.inMoney(inUser, money);
    }

}
