package com.yy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yy.domain.Student;
import com.yy.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/students")
public class StudentController2 {
//    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.list();
    }
    @PostMapping
    public Boolean save(@RequestBody Student stu){
        return studentService.save(stu);
    }
    @PutMapping
    public Boolean update(@RequestBody Student stu){
        return studentService.updateById(stu);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return studentService.removeById(id);
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.getById(id);
    }
    @GetMapping("{cur}/{siz}")
    public IPage<Student> getPage(@PathVariable int cur,@PathVariable int siz){
        return studentService.getPage(cur, siz);
    }

}
