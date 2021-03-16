package com.dreamplume.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Classname SpringUtil
 * @Description TODO
 * @Date 2021/3/15 19:00
 * @Created by 翊
 */

@Configurable  // 指定当前类是是相当于Spring配置类,当创建容器是会从该类上个加载注解
@ComponentScan("com.dreamplume")  // 相当于<context:component-scan base-package="com.dreamplume"/>

// 在使用 @Configurable 注解标识的 Spring 容器配置类以下使用 @import 注解引用其他的子配置类
// 其中的参数填写的是其他的子 Spring  容器配置类的字节对象
@Import({ServiceSpringUtil.class,WebSpringUtil.class})

public class SpringUtil {

}
