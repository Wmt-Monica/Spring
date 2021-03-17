package com.dreamplume.aop;

/**
 * @Classname Target
 * @Description TODO
 * @Date 2021/3/16 14:58
 * @Created by 翊
 */
public class Target implements TargetInterface{
    public void method() {
        System.out.println("method id running....");
    }
}
