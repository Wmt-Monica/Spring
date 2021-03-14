package com.dreamplume.factory.exampleFactory;

import com.dreamplume.dao.UserDao;
import com.dreamplume.impl.UserImpl;

/**
 * @Classname UserDaoFactory
 * @Description TODO
 * @Date 2021/3/13 18:10
 * @Created by 翊
 * UserDao 对象的工程实例方法实例化
 */
public class UserDaoFactory {

    public UserDao getUserDao() {
        return new UserImpl();
    }
}
