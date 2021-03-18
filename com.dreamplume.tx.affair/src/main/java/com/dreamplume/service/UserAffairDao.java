package com.dreamplume.service;

/**
 * @Classname UserAffairDao
 * @Description TODO
 * @Date 2021/3/18 14:54
 * @Created by 翊
 */
public interface UserAffairDao {
    public void transfer(String outUser, String inUser, int money);
}
