package com.dreamplume.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2021/3/16 9:32
 * @Created by 翊
 * 代理方法的测试
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象
        final User user = new User();
        // 增强对象
        final Enhance enhance = new Enhance();

        // jdk 的方法增强目标对象和增强对象之间要和目标对象的接口相连接

        UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(
                user.getClass().getClassLoader(),  //  目标对象的类加载器
                user.getClass().getInterfaces(),  //  目标对象的所有接口对象
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 使用加强对象的前置增强方法
                        enhance.before();
                        // 使用目标对象的执行的方法
                        Object invoke = method.invoke(user, args);
                        // 使用加强对象的后置增强方法
                        enhance.after();
                        return invoke;
                    }
                }
        );

        // 调用代理对象的方法
        userInterface.method();
    }
}
