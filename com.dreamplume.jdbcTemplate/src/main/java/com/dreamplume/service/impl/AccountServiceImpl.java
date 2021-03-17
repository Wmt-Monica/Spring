package com.dreamplume.service.impl;

import com.dreamplume.dao.AccountDao;
import com.dreamplume.service.AccountService;

/**
 * @Classname AccountServiceImpl
 * @Description TODO
 * @Date 2021/3/17 20:22
 * @Created by 翊
 */
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String outUserName, String inUserName, int money) {
        accountDao.inMoney(inUserName, money);
        accountDao.outMoney(outUserName, money);
    }
}
