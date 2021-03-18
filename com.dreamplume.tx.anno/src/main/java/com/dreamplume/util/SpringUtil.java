package com.dreamplume.util;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Classname SpringUtil
 * @Description TODO
 * @Date 2021/3/18 9:13
 * @Created by 翊
 */
@Configurable  // 指定当前类为配置类对象
@ComponentScan("com.dreamplume")  // 相当于<context:component-scan base-package="com.dreamplume"/>
// 使用 import 引用其他的配置类对象
@Import(ServiceUtil.class)
public class SpringUtil {

}
