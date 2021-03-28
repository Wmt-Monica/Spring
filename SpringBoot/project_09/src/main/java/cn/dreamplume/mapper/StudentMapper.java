package cn.dreamplume.mapper;

import cn.dreamplume.model.Student;
import org.apache.ibatis.annotations.Mapper;
// 使用 @Mapper 注解将该接口添加到 spring 容器当中去
// 这样可以创建该接口对象的后可以使用该接口中的方法，
// 该接口中的方法都对应 StudentMapper.xml 文件中实例封装好了
// @Mapper 作用：mybatis 自动扫描数据持久层的映射文件及 DAO 接口的关系
@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}