package com.example.demo.maper;

import com.example.demo.Pojo.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper {
    @Select("select * from student")
    List<student> selectAll();
}
