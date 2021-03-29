package cn.dreamplume.web;

import cn.dreamplume.model.Student;
import cn.dreamplume.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Classname StudentController
 * @Description TODO
 * @Date 2021/3/29 8:44
 * @Created by 翊
 */
@Controller
public class StudentController {

    @Resource(name = "studentService")
    StudentService studentService;

    @Transactional  // 表明以下的方法整体是一个事务
    @RequestMapping("/t1")
    public @ResponseBody String t1() {
        Student student = new Student();
        student.setId(1);
        student.setName("Hahn");
        studentService.updateByPrimaryKeySelective(student);
        Student student1 = new Student();
        student1.setId(1);
        student1.setAge(18);
        int i = 1/0;  // 此处报除数为零的错误，该整体作为一个事务会进行回滚的操作
        studentService.updateByPrimaryKeySelective(student1);
        return "success";
    }
}
