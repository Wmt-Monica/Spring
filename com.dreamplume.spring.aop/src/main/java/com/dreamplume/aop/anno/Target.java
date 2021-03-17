package com.dreamplume.aop.anno;

import org.springframework.stereotype.Component;

/**
 * @Classname Target
 * @Description TODO
 * @Date 2021/3/16 14:58
 * @Created by 翊
 */
@Component("target")
public class Target implements TargetInterface {
    public void method() {
        System.out.println("method id running....");
    }
}
