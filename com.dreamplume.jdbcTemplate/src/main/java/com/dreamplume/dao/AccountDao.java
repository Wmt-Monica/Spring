package com.dreamplume.dao;

/**
 * @Classname AccountDao
 * @Description TODO
 * @Date 2021/3/17 19:38
 * @Created by 翊
 */
public interface AccountDao {
    public void inMoney(String userName, int money);
    public void outMoney(String userName, int money);
}
