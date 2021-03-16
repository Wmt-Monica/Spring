package com.dreamplume.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Classname ServiceSpringUtil
 * @Description TODO
 * @Date 2021/3/15 20:06
 * @Created by 翊
 */
@PropertySource("classpath:jdbc.properties")  // 引入 resources 包下的 jdbc.properties 配置文件
public class ServiceSpringUtil {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("jdbcC3P0Pool2")  // 将该类变成 Bean 类存入 Spring 容器中,参数名相当于 Bean 的 id 名称
    public DataSource getDataSource() throws PropertyVetoException {
        // 创建数据源连接池对象
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass(driver);
        source.setJdbcUrl(url);
        source.setUser(username);
        source.setPassword(password);
        return source;
    }
}
