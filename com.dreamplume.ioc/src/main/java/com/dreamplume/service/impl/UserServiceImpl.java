package com.dreamplume.service.impl;

import com.dreamplume.dao.UserDao;
import com.dreamplume.impl.UserImpl;
import com.dreamplume.service.UserService;
import com.dreamplume.service.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Classname UserImple
 * @Description TODO
 * @Date 2021/3/13 18:35
 * @Created by 翊
 * service 包下的 UserService 接口的实现类
 */
public class UserServiceImpl implements UserService {

    // 创建集合对象
    private List<String> list;

    private Map<User,Integer> map;

    // 持久的属性集，属性列表中每个键及其对应值都是一个字符串
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<User, Integer> getMap() {
        return map;
    }

    public void setMap(Map<User, Integer> map) {
        this.map = map;
    }

    private UserDao userDao;

    String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void method() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao4");
        userDao.method();
    }

    // 有参构造方法来获取 UserDao 实例化对象
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // 无参构造方法
    public UserServiceImpl(){}

    // 注入依赖中方法一:创建set()方法
    public void setUserDao(UserImpl userDao) {
        this.userDao = userDao;
    }

    // 使用实例化号的成员变量对象 userDao 中的 method() 方法
    public void method2() {
        userDao.method();
    }

}

