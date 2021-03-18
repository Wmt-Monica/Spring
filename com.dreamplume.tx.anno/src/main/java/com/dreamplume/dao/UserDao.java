package com.dreamplume.dao;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/3/18 10:13
 * @Created by 翊
 */
public interface UserDao {
    public void inMoney(String userName, int money);
    public void outMoney(String userName, int money);
}
