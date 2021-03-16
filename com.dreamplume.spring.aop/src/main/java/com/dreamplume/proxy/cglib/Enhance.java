package com.dreamplume.proxy.cglib;

/**
 * @Classname Enhance
 * @Description TODO
 * @Date 2021/3/16 9:31
 * @Created by 翊
 * User 对象方法的增强对象的方法
 */
public class Enhance {
    public void before() {
        System.out.println("方法前置增强.....");
    }

    public void after() {
        System.out.println("方法后置增强....");
    }
}
