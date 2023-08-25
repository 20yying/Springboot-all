package com.yy;

import com.yy.dao.UsersDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo3ApplicationTests {

    @Autowired
    private UsersDao usersDao;

    @Test
    void contextLoads() {
        System.out.println(usersDao.getById(9));
    }
}
