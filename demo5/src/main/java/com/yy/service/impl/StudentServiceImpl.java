package com.yy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.dao.StudentDao;
import com.yy.domain.Student;
import com.yy.service.IStudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student>
        implements IStudentService {
    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage page= new Page(currentPage,pageSize);
        this.page(page,null);
        return page;
    }
    @Override
    public IPage<Student> getPage(int currentPage, int pageSize, Student student) {
        System.out.println(student.toString());
        //动态条件查询
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<Student>();
        lqw.like(student.getAge()!=null,Student::getAge,student.getAge());
        lqw.like(Strings.isNotEmpty(student.getName()),Student::getName,student.getName());
        lqw.like(Strings.isNotEmpty(student.getEmail()),Student::getEmail,student.getEmail());

        IPage page= new Page(currentPage,pageSize);
        this.page(page,lqw);
        return page;
    }
}
