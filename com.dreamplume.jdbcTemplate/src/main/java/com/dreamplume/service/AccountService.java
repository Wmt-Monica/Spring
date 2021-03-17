package com.dreamplume.service;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2021/3/17 20:21
 * @Created by 翊
 */
public interface AccountService {
    public void transfer(String outUserName, String inUserName, int money);
}
