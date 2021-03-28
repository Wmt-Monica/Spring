package cn.dreamplume.service.imp;

import cn.dreamplume.mapper.StudentMapper;
import cn.dreamplume.model.Student;
import cn.dreamplume.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImp
 * @Description TODO
 * @Date 2021/3/28 15:28
 * @Created by 翊
 */
// 将 StudentServiceImp 使用 @Service，将该对象放入 spring 容器中去，
// 为 StudentController 类对象中 studentService 属性进行注入
@Service
public class StudentServiceImp implements StudentService {

    @Autowired  // 根据类型对创建的 StudentMapper 对象进行注入
    private StudentMapper studentMapper;

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
