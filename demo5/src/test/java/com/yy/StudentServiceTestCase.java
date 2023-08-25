package com.yy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.domain.Student;
import com.yy.service.IStudentService;
import com.yy.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class StudentServiceTestCase {

    @Autowired
    private IStudentService studentService;

    @Test
    void test1(){
        System.out.println(studentService.getById(3));
    }
    @Test
    void test2(){
        System.out.println(studentService.removeById(2));
    }
    @Test
    void test3(){
        System.out.println(studentService.list());
    }
    @Test
    void test4(){
        Student stu = new Student();
        stu.setName("孙宁");
        stu.setAge(25);
        stu.setEmail("sunning@google.com");
        System.out.println(studentService.save(stu));
    }
    @Test
    void test5(){
        Student stu = new Student();
        stu.setId(3);
        stu.setName("李三");
        stu.setEmail("lisan@google.com");
        System.out.println(studentService.updateById(stu));
    }
    @Test
    void test6(){
        IPage<Student> page = new Page<Student>();
        studentService.page(page);
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getSize());//每页大小
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数
        System.out.println(page.getRecords());//获得的记录
    }
}
