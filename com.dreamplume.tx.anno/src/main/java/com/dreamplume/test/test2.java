package com.dreamplume.test;

import com.dreamplume.service.UserTransfer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname test2
 * @Description TODO
 * @Date 2021/3/18 19:32
 * @Created by 翊
 */
public class test2 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserTransfer userTransfer = (UserTransfer) app.getBean("userTransferImpl");
        userTransfer.transfer("Monica","Hahn",100);
    }
}
