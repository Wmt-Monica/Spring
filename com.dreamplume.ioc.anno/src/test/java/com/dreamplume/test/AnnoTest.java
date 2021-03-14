package com.dreamplume.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2021/3/14 13:28
 * @Created by 翊
 */
public class AnnoTest {

    // 创建一个 c3p0 连接池对象
    @Test
   public void test1() throws Exception {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass("com.mysql.jdbc.properties.Driver");
        source.setJdbcUrl("jdbc.properties:mysql://localhost:3306/formdata");
        source.setUser("root");
        source.setPassword("mengmengmeng0501");
        source.setInitialPoolSize(5);
        source.setMaxPoolSize(20);
        // 从连接池中获取连接对象
        Connection conn = source.getConnection();
        System.out.println(conn);
        // 归还Connection对象到连接池
        conn.close();
   }

   // 创建一个 druid 连接池对象
    @Test
    public void test2() throws SQLException {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.properties.Driver");
        source.setUrl("jdbc.properties:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("mengmengmeng0501");
        DruidPooledConnection conn = source.getConnection();
        System.out.println(conn);
        conn.close();
    }

    // 创建一个 druid 连接池对象（读取配置文件）
    @Test
    public void test3() throws Exception {
        // 创建 ResourceBundle 读取 resources 下的文件的对象
        // 注意要使用 ResourceBundle 对象读取 resources 目录下文件要确定文件的类型，
        // 不是普通的文件类型，其次输入的参数不包括文件的后缀名称
        ResourceBundle read = ResourceBundle.getBundle("jdbc");
        String driver = read.getString("jdbc.driver");
        String url = read.getString("jdbc.url");
        String username = read.getString("jdbc.username");
        String password = read.getString("jdbc.password");
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass(driver);
        source.setJdbcUrl(url);
        source.setUser(username);
        source.setPassword(password);

        Connection conn = source.getConnection();
        System.out.println(conn);
        conn.close();
    }

    // 使用 Spring 配置文件来获取其中的 bean 对象来获取 c3p0 连接池对象
    @Test
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource source = (DataSource) app.getBean("jdbcPool");
        Connection conn = source.getConnection();
        System.out.println(conn);
        conn.close();
    }

    // 使用 Spring 配置文件来获取文件中的 bean 对象获取 druid 连接池对象
    @Test
    public void test5() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource source = (DataSource) app.getBean("jdbcDruidPool");
        Connection conn = source.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
