package com.yy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yy.controller.utils.R;
import com.yy.domain.Student;
import com.yy.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public R getAll(){
       return new R(true,studentService.list(),null);
    }
    @PostMapping
    public R save(@RequestBody Student stu) throws IOException {
        if(stu.getName().equals("222")) throw new IOException();
        boolean flag = studentService.save(stu);
        return new R(flag,null, flag ? "添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody Student stu){
        return new R(true,studentService.updateById(stu),null);
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,studentService.removeById(id),null);
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return R.ok(studentService.getById(id));
    }

//    @GetMapping("{cur}/{siz}")
//    public R getPage(@PathVariable int cur,@PathVariable int siz){
//        IPage<Student> page = studentService.getPage(cur, siz);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用大页码值作为当前页码值
//        if(cur > page.getPages()){
//            //getPages()是总页数
//            page = studentService.getPage(1,siz);
//        }
//        return R.ok(page);
//    }

    @GetMapping("{cur}/{siz}")
    public R getPage(@PathVariable int cur,@PathVariable int siz,Student stu){
        IPage<Student> page = studentService.getPage(cur, siz,stu);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用大页码值作为当前页码值
        if(cur > page.getPages()){
            //getPages()是总页数
            page = studentService.getPage(1,siz,stu);
        }
        return R.ok(page);
    }
}
