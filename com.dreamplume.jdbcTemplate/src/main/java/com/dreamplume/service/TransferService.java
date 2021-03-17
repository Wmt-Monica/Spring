package com.dreamplume.service;

import com.dreamplume.po.Transfer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @Classname TransferService
 * @Description TODO
 * @Date 2021/3/17 9:06
 * @Created by 翊
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransferService {

    @Test
    public void test1() throws Exception {
        // 创建数据源对象首先要在 pom.xml 中引入 c3p0 和 mysql
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/formdata");
        dataSource.setUser("root");
        dataSource.setPassword("mengmengmeng0501");
        // 创建 JdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源给 JdbcTemplate 对象
        jdbcTemplate.setDataSource(dataSource);
        // 执行操作
        jdbcTemplate.update("insert into transfer values(?,?)","Monica",1314);
    }

    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    // 创建使用 applicationContext.xml 配置好的 bean 对象来获得 JdbcTemplate 对象
    @Test
    public void test2() {
        jdbcTemplate.update("insert into transfer values(?,?)","Hahn",1314);
    }

    // jdbcTemplate 对象的数据库表修改操作
    @Test
    public void update() {
        jdbcTemplate.update("update transfer set balance = ? where userName = ?",520,"Hahn");
    }

    // jdbcTemplate 对象的数据库的删除操作
    @Test
    public void delete() {
        jdbcTemplate.update("delete from transfer where userName = ?","Monica");
    }

    // jdbcTemplate 对象的数据库的查询操作
    @Test
    public void queryAll() {
        List<Transfer> transfers = jdbcTemplate.query(
                "select * from transfer",new BeanPropertyRowMapper<Transfer>(Transfer.class));
        for (Transfer t : transfers) {
            System.out.println(t);
        }
    }

    //  jdbcTemplate 对象的数据库的查询单个查询对象操作
    @Test
    public void queryObject() {
        Transfer transfer = jdbcTemplate.queryForObject(
                "select * from transfer where userName = ?",
                new BeanPropertyRowMapper<Transfer>(Transfer.class),"Hahn");
        System.out.println(transfer);
    }

    // jdbcTemplate 对象的数据库的查询对象数量的操作
    @Test
    public void queryCount() {
        Long count = jdbcTemplate.queryForObject(
                "select count(*) from transfer",Long.class);
        System.out.println("count = "+count);
    }

}
