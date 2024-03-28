package com.example.demo.Contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Pojo.Result;
import com.example.demo.Pojo.Student;
import com.example.demo.maper.userMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class userContorller {
    @Autowired
    private userMapper um;

    //登录
    @PostMapping("/Login")
    public Result Login(@RequestBody Student student){
        //创建构造器
        QueryWrapper queryWrapper=new QueryWrapper<>();

        queryWrapper.eq("student_name",student.getStudentName());

        Student st = um.selectOne(queryWrapper);

        if (st != null && st.getPassword().equals(student.getPassword())){
            return Result.success();
        }else {
            return Result.error("登录失败");
        }
    }

    //注册
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student student){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_name",student.getStudentName());
        Student st = um.selectOne(queryWrapper);
        if (st == null){
            um.insert(student);
            return Result.success();
        }else {
            return Result.error("注册失败");
        }
    }

    //查询个人信息
    @GetMapping("/selectOne")
    public Result selectStudent(@RequestParam String studentName){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_name",studentName);
        Student st = um.selectOne(queryWrapper);
        if (st != null) {
            return Result.success(st);
        }else {
            return Result.error("查询失败");
        }
    }
    //修改个人信息
    @PutMapping("/changeStudent")
    public Result changeStudent(@RequestBody Student student){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_name",student.getStudentName());
        Student st = um.selectOne(queryWrapper);
        student.setPassword(st.getPassword());
        student.setStudentId(st.getStudentId());
        um.update(student,queryWrapper);
        return Result.success();
    }
    //删除学生
    @DeleteMapping("/delectStudet")
    public Result deleteStudent(@RequestParam String studentName){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_name",studentName);
        um.delete(queryWrapper);
        return Result.success();
    }
    //查询学生
    @GetMapping("/select")
    public Result selectStudents(@RequestParam String major){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("major",major);
        return Result.success(um.selectList(queryWrapper));
    }
}
