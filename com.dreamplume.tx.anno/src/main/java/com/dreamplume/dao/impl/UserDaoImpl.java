package com.dreamplume.dao.impl;

import com.dreamplume.dao.UserDao;
import com.dreamplume.util.SpringUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Classname USerDaoImpl
 * @Description TODO
 * @Date 2021/3/18 10:14
 * @Created by 翊
 */
@Repository("userDaoImpl")  // 在 dao 层 类上定义此为一个 bean 类对象
@ContextConfiguration(classes = SpringUtil.class)  // 应用要使用的 Spring 容器配置类
public class UserDaoImpl implements UserDao {


    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;


    public void inMoney(String userName, int money) {
        jdbcTemplate.update("update transfer set balance = balance + ? where userName = ?",money,userName);
    }

    public void outMoney(String userName, int money) {
        jdbcTemplate.update("update transfer set balance = balance - ? where userName = ?",money,userName);
    }

}
