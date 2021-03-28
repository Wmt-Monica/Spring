package cn.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname ViewController
 * @Description TODO
 * @Date 2021/3/26 19:33
 * @Created by 翊
 */
@Controller
public class ViewController {

    @RequestMapping("/t")
    public ModelAndView test1() {
        // 创建 ModelAndView 对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data","success");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
