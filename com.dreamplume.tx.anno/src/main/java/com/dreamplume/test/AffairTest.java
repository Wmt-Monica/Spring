package com.dreamplume.test;

import com.dreamplume.service.UserTransfer;
import com.dreamplume.service.impl.UserTransferImpl;
import com.dreamplume.util.ServiceUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Classname AffairTest
 * @Description TODO
 * @Date 2021/3/18 9:25
 * @Created by 翊
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceUtil.class})  // 调用对应的配置类
//@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class AffairTest {
    @Resource(name= "jdbcC3P0Pool")
    ComboPooledDataSource dataSource;

    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Resource(name = "userTransferImpl")
    UserTransfer userTrance;

    @Test
    public void test1() {
        userTrance.transfer("Hahn","Monica",100);
    }
}
