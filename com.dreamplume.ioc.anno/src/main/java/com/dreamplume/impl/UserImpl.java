package com.dreamplume.impl;

import com.dreamplume.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;


/**
 * @Classname UserImpl
 * @Description TODO
 * @Date 2021/3/15 8:50
 * @Created by 翊
 */
//@Component("UserImpl")
@Repository("UserImpl")  // 与上面的注解功能一样,不过时 dao 包下的 bean 初始化注解,有可读性

// 使用 @PropertySource 其中参数填写 classpath: 后面填写要引入的配置文件
@PropertySource("classpath:jdbc.properties")
public class UserImpl implements UserDao {
    /*
        结合 applicationContext.xml 配置文件对 jdbc.properties 的引入
        <context:property-placeholder location="jdbc.properties"/>
        我们可以使用在jdbc.properties文件中对 name age 属性的属性值的信
        来对其进行使用 "${参数名称}" 来获取其属性值
     */
    @Value("${name}")  // 普通的数据注入
    private String name;

    @Value("${age}")  // 普通的苏剧注入
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
