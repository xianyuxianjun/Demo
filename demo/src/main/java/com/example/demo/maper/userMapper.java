package com.example.demo.maper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper extends BaseMapper<Student> {

}
