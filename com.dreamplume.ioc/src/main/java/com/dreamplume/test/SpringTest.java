package com.dreamplume.test;

import com.dreamplume.dao.UserDao;
import com.dreamplume.service.domain.User;
import com.dreamplume.service.impl.UserClassDemo;
import com.dreamplume.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Properties;

/**
 * @Classname SpringTest
 * @Description TODO
 * @Date 2021/3/13 15:16
 * @Created by 翊
 */
public class SpringTest {
    @Test
    public void test1() {
        // scope属性:对象的作用范围：（默认）是 singleton 单例的，只有一个实例对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        // 通过比较对象的 hash 值是否相同来判断是否为同一个实例对象
        if (userDao1.hashCode() == userDao2.hashCode()) {
            System.out.println("是相同的实例对象");
        }else {
            System.out.println("不是相同的实例对象");
        }
    }

    @Test
    public void test2() {
        // scope属性:对象的作用范围：scope:修改成 prototype（多例），创建出来的对象不是同一个对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao2");
        UserDao userDao2 = (UserDao) app.getBean("userDao2");
        // 通过比较对象的 hash 值是否相同来判断是否为同一个实例对象
        if (userDao1.hashCode() == userDao2.hashCode()) {
            System.out.println("是相同的实例对象");
        }else {
            System.out.println("不是相同的实例对象");
        }
    }

    @Test
    public void test3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao3");
        userDao.method();
    }

    @Test
    public void test4() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao4");
        userDao.method();
    }

    @Test
    public void test5() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao5");
        userDao.method();
    }

    @Test
    public void test6() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("UserDaoService");
        userService.method2();
    }

    @Test
    public void test7() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("UserDaoService2");
        userService.method2();
    }

    @Test
    public void test8() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("UserDaoService3");
        userService.method2();
    }

    @Test
    public void test9() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("UserDaoService4");
        System.out.println(userService.getName());
        System.out.println(userService.getAge());
    }

    @Test
    public void test10() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("UserDaoService5");
        System.out.println(userService.getList());
        Map<User,Integer> map = userService.getMap();
        for (Map.Entry<User,Integer> entry : map.entrySet()) {
            System.out.println("key.name = "+entry.getKey().getName()+"\tkey.age = "+entry.getKey().getAge()+"\tvalue = "+entry.getValue());
        }
        Properties properties = userService.getProperties();
        for (Map.Entry<Object, Object> prop : properties.entrySet()) {
            System.out.println("key = "+prop.getKey()+"\tvalue = "+prop.getValue());
        }
    }

    @Test
    public void test11() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用 getBean(Class<T>) 传入类的字节对象为参数获取配置文件中的对象
        // 注意 配置文件中 bean 对象的 class 只是唯一的，不然会因为多个相同的 class 类型而报错
        UserClassDemo demo = app.getBean(UserClassDemo.class);
        demo.method();
    }
}
