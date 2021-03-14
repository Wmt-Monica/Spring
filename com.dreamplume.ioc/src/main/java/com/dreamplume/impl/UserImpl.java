package com.dreamplume.impl;

import com.dreamplume.dao.UserDao;

/**
 * @Classname Userimpl
 * @Description TODO
 * @Date 2021/3/13 14:44
 * @Created by 翊
 * UserDao 接口的实现类
 */
public class UserImpl implements UserDao {

    public void method() {
        System.out.println("UserDao 接口的 method() 方法的实现....");
    }

    public void init() {
        System.out.println("userDeo 对象被初始化....");
    }

    public void destroy() {
        System.out.println("UserDeo 对象被销毁....");
    }
}
