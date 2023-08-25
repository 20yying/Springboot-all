package com.yy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.dao.StudentDao;
import com.yy.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo5ApplicationTests {
    @Autowired
    private StudentDao studentDao;
    @Test
    void contextLoads() {
        IPage page = new Page(2,2);
        studentDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }

    @Test
    void test1() {
        String str = "1234";

        change(str);
        System.out.println(str);
    }
    private static void change(String str) {
        str ="hell0";
    }
}
