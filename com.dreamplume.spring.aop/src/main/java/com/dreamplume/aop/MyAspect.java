package com.dreamplume.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Classname MyAspect
 * @Description TODO
 * @Date 2021/3/16 14:57
 * @Created by 翊
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("execution(public void com.dreamplume.aop.anno.Target.method())")
    public void before() {
        System.out.println("前置方法....");
    }

    @AfterReturning("execution(public void com.dreamplume.aop.anno.Target.method())")
    public void afterReturning() {
        System.out.println("后置方法....");
    }

    @Around("execution(public void com.dreamplume.aop.anno.Target.method())")
    // ProceedingJoinPoint : 正在执行的连接点 == 切点
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强....");
        Object o = joinPoint.proceed();  // 切点方法
        System.out.println("环绕后增强....");
        return o;
    }
}
