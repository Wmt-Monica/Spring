package com.dreamplume.test;

import com.dreamplume.service.UserAffairDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname XmlAffairTest
 * @Description TODO
 * @Date 2021/3/18 16:08
 * @Created by 翊
 */
public class XmlAffairTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAffairDao userAffairDao = (UserAffairDao) app.getBean("userAffairDaoImpl");
        userAffairDao.transfer("Hahn","Monica",100);
    }
}
