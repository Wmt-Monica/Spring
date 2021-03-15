package com.dreamplume.impl;

import com.dreamplume.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * @Classname UserImpl
 * @Description TODO
 * @Date 2021/3/15 8:50
 * @Created by 翊
 */
//@Component("UserImpl")
@Repository("UserImpl")  // 与上面的注解功能一样,不过时 dao 包下的 bean 初始化注解,有可读性
public class UserImpl implements UserDao {

    @Value("Monica")  // 普通的数据注入
    private String name;

    @Value("19")  // 普通的苏剧注入
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void method() {
        System.out.println("UserImpl method is running....");
    }
}
