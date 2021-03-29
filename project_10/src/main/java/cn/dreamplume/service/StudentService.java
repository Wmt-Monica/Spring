package cn.dreamplume.service;

import cn.dreamplume.model.Student;

/**
 * @Classname StudentService
 * @Description TODO
 * @Date 2021/3/29 8:44
 * @Created by 翊
 */
public interface StudentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
