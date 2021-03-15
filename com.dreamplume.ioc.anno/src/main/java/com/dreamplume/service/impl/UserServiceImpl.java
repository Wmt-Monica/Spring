package com.dreamplume.service.impl;

import com.dreamplume.impl.UserImpl;
import com.dreamplume.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/3/15 8:58
 * @Created by 翊
 */
// 使用注解方便程序执行直接扫描该类对象的组注解
//@Component("UserService")  // 参数类似 xml 文件中的 bean 类的 id 唯一属性
@Service("UserService")  // 与上面的注解功能一样,是对象bean对象的初始化,不过标示用于 service 包下的,可读性高
public class UserServiceImpl implements UserService {
//    @Autowired  //  在使用字段上用于根据类型依赖注入
//    @Qualifier("UserImpl")  //  结合 @Autowired 一起使用,用于名称的依赖注入
    @Resource(name = "UserImpl")  // 相当于上面两个相结合使用名称来搜寻 bean 对象
    UserImpl userImpl;

    public UserImpl getUserImpl() {
        return userImpl;
    }

    public void setUserImpl(UserImpl userImpl) {
        this.userImpl = userImpl;
    }

    // 有参构造

    public UserServiceImpl(UserImpl userImpl) {
        this.userImpl = userImpl;
    }

    // 无参构造
    public UserServiceImpl() { }

    public void method() {
        System.out.println("USerServiceImpl method is running....");
    }
}
