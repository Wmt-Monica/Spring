package com.dreamplume.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2021/3/16 9:32
 * @Created by 翊
 * 代理方法的测试
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 创建目标对象
        final User user = new User();
        // 创建增强对象
        final Enhance enhance = new Enhance();
        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类（目标对象）
        enhancer.setSuperclass(User.class);
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 调用增强对象的前置方法增强
                enhance.before();
                // 调用目标对象的目标方法
                Object invoke = method.invoke(user, objects);
                // 调用增强对象的后置方法增强
                enhance.after();
                return invoke;
            }
        });

        // 创建代理对象
        User user1 = (User) enhancer.create();
        user1.method();
    }
}
