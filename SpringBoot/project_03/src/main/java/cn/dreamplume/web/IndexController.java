package cn.dreamplume.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2021/3/26 14:57
 * @Created by 翊
 */
@Controller
public class IndexController {

    @RequestMapping("/t")
    public @ResponseBody String test() {
        return "success";
    }
}
