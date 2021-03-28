package cn.dreamplume.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2021/3/26 16:13
 * @Created by 翊
 */
@Controller
public class IndexController {

    // 使用 @Value 注解获取 application.properties 配置文件中的自定义数据的值
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @RequestMapping("/test")
    public @ResponseBody String test() {
        return "name = "+name+"\tage = "+age;
    }
}
