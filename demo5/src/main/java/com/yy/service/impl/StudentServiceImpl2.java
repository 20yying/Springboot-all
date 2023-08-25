package com.yy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.dao.StudentDao;
import com.yy.domain.Student;
import com.yy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl2 implements StudentService {
    @Autowired
    private StudentDao studentdao;
    @Override
    public Boolean save(Student student) {
        return studentdao.insert(student) > 0;
    }

    @Override
    public Boolean update(Student student) {
        return studentdao.updateById(student)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return studentdao.deleteById(id)>0;
    }

    @Override
    public Student getById(Integer id) {
        return studentdao.selectById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentdao.selectList(null);
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);

        return studentdao.selectPage(page,null);
    }


}
