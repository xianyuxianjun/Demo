package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Student {
    private String studentName;
    @TableId
    private  Integer studentId;
    private String password;
    private int age;
    private String gender;
    private String major;
}
