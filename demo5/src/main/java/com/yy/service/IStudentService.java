package com.yy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.domain.Student;

import java.awt.print.Book;

public interface IStudentService extends IService<Student> {
    IPage<Student> getPage(int currentPage,int pageSize);
    IPage<Student> getPage(int currentPage,int pageSize,Student student);

}
