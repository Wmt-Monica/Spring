package com.dreamplume.factory.staticFactory;

import com.dreamplume.dao.UserDao;
import com.dreamplume.impl.UserImpl;

/**
 * @Classname UserDeo
 * @Description TODO
 * @Date 2021/3/13 17:52
 * @Created by 翊
 * UserDeo 对象的工厂静态方法实例化
 */
public class UserDaoFactory {
    // 返回值时接口类型
    public static UserDao getUserDao() {
        // 将实现了 UserDeo 接口的 UserImpl 类对象返回
        // 配置 applicationContext.xml 配置文件来指定返回工厂的静态方法实例化对象
        return new UserImpl();
    }
}
