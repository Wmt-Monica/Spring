package cn.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname indexController
 * @Description TODO
 * @Date 2021/3/26 10:29
 * @Created by 翊
 */
@Controller
@RequestMapping("/index")
public class Index {

    @RequestMapping(value = "/t1")
    @ResponseBody
    public String test1() {
        return "success";
    }

    @RequestMapping("/t2")
    public @ResponseBody Map<String,Integer> test2() {
        Map<String,Integer> map = new HashMap<>();
        map.put("王梦婷",19);
        return map;
    }
}
