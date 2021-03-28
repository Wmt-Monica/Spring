package cn.dreamplume.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname School
 * @Description TODO
 * @Date 2021/3/26 16:46
 * @Created by 翊
 */

// 创建一个而自定义的 Java 类来用于在 application 配置配置文件中获取 自定义对象属性值
// 首先自定义类要先加上 @Component
// 加上 @ConfigurationProperties 注解，填写 prefix 属性，可以用来区分相同属性名称的时候
// 可以为每一个不同的 java 类添加一个不一样的 prefix 的名称，这样在 application 配置文件
// 中给该属性赋值的时候可以更加的准确的赋值到对应对象的对应属性
@Component
@ConfigurationProperties(prefix = "school")
public class School {
    private String name;
    private String websit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsit() {
        return websit;
    }

    public void setWebsit(String websit) {
        this.websit = websit;
    }

    public School() {}

    public School(String name, String websit) {
        this.name = name;
        this.websit = websit;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", websit='" + websit + '\'' +
                '}';
    }
}
