package cn.dreamplume.service;

import cn.dreamplume.model.Student;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/3/28 15:27
 * @Created by 翊
 */
public interface StudentService {
    Student selectByPrimaryKey(Integer id);
}
