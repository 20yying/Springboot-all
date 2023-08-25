package com.yy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yy.domain.Student;

import java.util.List;

public interface StudentService {
    Boolean save(Student student);
    Boolean update(Student student);
    Boolean delete(Integer id);
    Student getById(Integer id);
    List<Student> getAll();
    IPage<Student> getPage(int currentPage,int pageSize);
}
