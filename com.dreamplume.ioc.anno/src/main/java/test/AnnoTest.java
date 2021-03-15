package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.dreamplume.impl.UserImpl;
import com.dreamplume.service.impl.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Classname AnnoTest
 * @Description TODO
 * @Date 2021/3/15 9:11
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

    // 在 applicationContext.xml 配置文件上引用jdbc.properties配置文件的连接池的配置信息
    @Test
    public void test6() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource source = (DataSource) app.getBean("jdbcC3P0Pool2");
        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    @Test
    public void test7() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("UserService");
        UserServiceImpl userService2 = (UserServiceImpl) app.getBean("UserService");
        UserImpl user = userService.getUserImpl();
        user.method();
        System.out.println("name = "+user.getName());
        System.out.println("age = "+user.getAge());

        // 使用 ClassPathXmlApplicationContext 类的 close() 释放资源
        // 来显示 userService 对象的销毁方法的执行
        ((ClassPathXmlApplicationContext) app).close();

        if (userService.hashCode() == userService2.hashCode()) {
            System.out.println("是默认的单例状态");
        }else {
            System.out.println("是指定的多例状态");
        }
    }
}
