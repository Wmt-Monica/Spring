package com.dreamplume.dao;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/3/18 14:52
 * @Created by 翊
 */
public interface UserDao {
    public void inMoney(String name, int money);
    public void  outMoney(String name, int money);
}
