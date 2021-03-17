package com.dreamplume.dao.impl;

import com.dreamplume.dao.AccountDao;
import com.dreamplume.po.Transfer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Classname AccountImpl
 * @Description TODO
 * @Date 2021/3/17 19:38
 * @Created by 翊
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountImpl implements AccountDao {

    @Resource(name = "jdbcTemplate2")
    JdbcTemplate jdbcTemplate;

    public void inMoney(String userName, int money) {
        jdbcTemplate.update("update transfer set balance = balance + ? where userName = ?",money,userName);

    }

    public void outMoney(String userName, int money) {
        jdbcTemplate.update("update transfer set balance = balance - ? where userName = ?",money,userName);
    }

}
