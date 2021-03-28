package cn.dreamplume.web;

import cn.dreamplume.model.Student;
import cn.dreamplume.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/3/28 15:57
 * @Created by 翊
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    public @ResponseBody Student test1() {
        return studentService.selectByPrimaryKey(1);
    }

    @RequestMapping("/t")
    public @ResponseBody String test2() {
        return "success";
    }
}
