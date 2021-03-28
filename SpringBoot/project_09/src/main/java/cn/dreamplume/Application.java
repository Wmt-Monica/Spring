package cn.dreamplume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 添加 @MapperScan 注解，扫描 Mapper 接口及其子类，避免多处的接口对象使用xml配置中的mybatis
// sql 语句，多处接口对象使用 @Mapper 注解
@MapperScan(basePackages = "cn.dreamplume.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
