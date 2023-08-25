package com.yy.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.domain.Student;
import com.yy.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class StudentDaoTestCase {

    @Autowired
    private StudentService studentService;
    @Test
    void test1(){
        System.out.println(studentService.getById(3));
    }
    @Test
    void test2(){
        System.out.println(studentService.delete(2));
    }
    @Test
    void test3(){
        System.out.println(studentService.getAll());
    }
    @Test
    void test4(){
        Student stu = new Student();
        stu.setName("王小小");
        stu.setAge(26);
        stu.setEmail("12315wxx@google.com");
        System.out.println(studentService.save(stu));
    }
    @Test
    void test5(){
        Student stu = new Student();
        stu.setId(3);
        stu.setName("欧云");
        stu.setEmail("ouyun@google.com");
        System.out.println(studentService.update(stu));
    }
    @Test
    void test6(){
        IPage<Student> page1 = new Page(1,5);
        IPage<Student> page = studentService.getPage(1,5);
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getSize());//每页大小
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数
        System.out.println(page.getRecords());//获得的记录
    }
}
