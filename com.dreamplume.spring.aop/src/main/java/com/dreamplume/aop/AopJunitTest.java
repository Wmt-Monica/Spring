package com.dreamplume.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @Classname AopJunitTest
 * @Description TODO
 * @Date 2021/3/16 15:25
 * @Created by 翊
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopJunitTest {
    @Autowired // 按照字段类型中根据名称来寻找bean对象
    private TargetInterface target;

    @Test
    public void test1() {
        target.method();
    }

}
