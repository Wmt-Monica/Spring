package com.dreamplume.dao.impl;

import com.dreamplume.dao.UserDao;
import com.dreamplume.util.SpringUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2021/3/18 14:53
 * @Created by 翊
 */
@Repository("userDaoImpl")
@ContextConfiguration(classes = SpringUtil.class)  // 引用使用的 spring 容器类对象
public class UserDaoImpl implements UserDao {

    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    public void inMoney(String name, int money) {
        jdbcTemplate.update("update transfer set balance = balance + ? where userName = ?",money,name);
    }

    public void outMoney(String name, int money) {
        jdbcTemplate.update("update transfer set balance = balance - ? where userName = ?",money,name);
    }

}
