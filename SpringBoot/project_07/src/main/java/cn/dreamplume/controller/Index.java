package cn.dreamplume.controller;

import cn.dreamplume.config.School;
import cn.dreamplume.config.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Classname Index
 * @Description TODO
 * @Date 2021/3/26 16:55
 * @Created by 翊
 */
@Controller
public class Index {

    @Autowired
    private School school;

    @Autowired
    private Student student;

    @RequestMapping("/t1")
    public @ResponseBody String test1() {
        return school.getName()+"------------"+school.getWebsit();
    }

    @RequestMapping("/t2")
    public @ResponseBody String test2() {
        return student.getName()+"------------"+student.getAge();
    }
}
