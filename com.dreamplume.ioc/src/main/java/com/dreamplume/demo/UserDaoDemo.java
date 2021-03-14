package com.dreamplume.demo;

import com.dreamplume.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname UserDaoDemo
 * @Description TODO
 * @Date 2021/3/13 14:54
 * @Created by 翊
 * 使用 Spring  API 获得 Bean 实例
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        // 获取 application.xml 文件的 API 对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用 getBean() 方法根据 bean 中的 id 获取 <bean> 中的信息对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        // 调用对象中的方法
        userDao.method();
    }
}
