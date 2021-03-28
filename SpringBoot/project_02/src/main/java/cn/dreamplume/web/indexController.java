package cn.dreamplume.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname indexController
 * @Description TODO
 * @Date 2021/3/26 10:57
 * @Created by 翊
 */
@Controller
public class indexController {

    // 访问路径：http://localhost:8081/project_02/t
    @RequestMapping("/t")
    public @ResponseBody String test1() {
        return "success";
    }
}
