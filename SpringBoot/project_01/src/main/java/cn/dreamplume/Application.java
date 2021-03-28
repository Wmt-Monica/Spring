package cn.dreamplume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 注意：SpringBoot 项目代码必须放到 Application 类所在的同级目录下级目录
// SpringBoot 项目的启动入口类
@SpringBootApplication  // SpringBoot 项目核心注解
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
