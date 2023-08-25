package com.yy;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.dao.UsersDao;
import com.yy.domain.Users;
import com.yy.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Demo4ApplicationTests {
    @Autowired
    private UsersDao usersDao;

    /**
     * 乐观锁
     */
    @Test
    void test7(){
//        Users users = new Users();
//        users.setId(5);
//        users.setUsername("张四丰");
//        users.setVersion(1);
//        usersDao.updateById(users);

        //1.先通过要修改的数据id将当前的数据查出
        Users users = usersDao.selectById(5);
        //2.将要修改的数据逐一设置进去
        users.setUsername("张三丰");
        usersDao.updateById(users);
    }

    /**
     * 逻辑删除
     */
    @Test
    void test6(){
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(11,12);
        list.addAll(list1);
        usersDao.deleteBatchIds(list);
    }

    /**
     * 批量删除
     */
    @Test
    void test5(){
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(12, 13);
        list.addAll(list1);
        usersDao.deleteBatchIds(list);
    }


    /**
     * 范围查询/模糊查询
     */
    @Test
    void test4(){
        LambdaQueryWrapper<Users> qw = new LambdaQueryWrapper<Users>();
//        qw.between(Users::getAge,10,20);
        qw.likeLeft(Users::getAddress,"市");
        List<Users> us = usersDao.selectList(qw);
        System.out.println(us);
    }

    /**
     * 多条件查询
     */
    @Test
    void test3(){
        LambdaQueryWrapper<Users> qw = new LambdaQueryWrapper<Users>();
        qw.eq(Users::getUsername,"李一").eq(Users::getAge,19);

        Users us = usersDao.selectOne(qw);
        System.out.println(us);
    }


    /**
     * 查询投影
     */
    @Test
    void test2(){
//        UserQuery uq = new UserQuery();
//        LambdaQueryWrapper<Users> lqw = new LambdaQueryWrapper<>();
//        lqw.select(Users::getId,Users::getUsername,Users::getAge);
//        List<Users> users2 = usersDao.selectList(lqw);
//        System.out.println(users2);

        UserQuery uq = new UserQuery();
        QueryWrapper<Users> lqw = new QueryWrapper<>();
        lqw.select("count(*) as count, age");
        lqw.groupBy("age");
        List<Map<String,Object>> users2 = usersDao.selectMaps(lqw);
        System.out.println(users2);

    }

    /**
     * 普通条件查询
     */
    @Test
    void testGetAll(){
        //方式1：按条件查询
        QueryWrapper qw = new QueryWrapper();
//        qw.lt("id",13);//相当于 (id < ? AND id > ?)
//        qw.gt("id",10);//id > ?

        List<Users> usersList = usersDao.selectList(qw);
        System.out.println(usersList);

        //方式2：按条件查询
//        QueryWrapper qw = new QueryWrapper();
//        qw.lambda().lt(Users::getId,10);
//        List<Users> usersList = usersDao.selectList(qw);

    }

    /**
     * 条件查询 lambda
     */
    @Test
    void contextLoads() {
        /*List<Users> users1 = usersDao.selectList(null);
        System.out.println(users1.toString());
        Users users = usersDao.selectById(2);
        System.out.println(users);
        System.out.println(users);
        System.out.println(users);*/

        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<Users>();
//        queryWrapper.eq(Users::getId,7);

        /**查询id10到13，直接连接就是并且
         * qw.lt("id",13);//相当于 (id < ? AND id > ?)
         * qw.gt("id",10);//id > ?
         *
         * 也可以写成： qw.lt(Users::getId,13).gt(Users::getId,10);
         */

        //查询id小于10或者大于13，加个or就是或
        queryWrapper.lt(Users::getId,10).or().gt(Users::getId,13);


        List<Users> users2 = usersDao.selectList(queryWrapper);
        System.out.println(users2.toString());
    }

    /**
     * 条件查询null判定
     */
    @Test
    void test1(){
//        UserQuery uq = new UserQuery();
//        uq.setAge(10);
//        uq.setAge2(20);//设置为上限
//        LambdaQueryWrapper<Users> lqw = new LambdaQueryWrapper<>();
//        lqw.lt(Users::getAge,uq.getAge2());
//        lqw.gt(Users::getAge,uq.getAge());


        UserQuery uq = new UserQuery();
//        uq.setAge(10);
        uq.setAge2(15);//设置为上限
        LambdaQueryWrapper<Users> lqw = new LambdaQueryWrapper<>();
        //先判定第一个参数是否为true,如果为true连接当前条件
        //lt是小于，gt是大于
        lqw.lt(null != uq.getAge2(), Users::getAge, uq.getAge2());
        lqw.gt(null != uq.getAge(), Users::getAge, uq.getAge());

        List<Users> users2 = usersDao.selectList(lqw);
        System.out.println(users2.toString());
    }


    /**
     * 分页查询功能
     */
    @Test
    void testGetByPage(){
        IPage page = new Page(1,5);
        usersDao.selectPage(page,null);
        System.out.println("当前页码值 " + page.getCurrent());
        System.out.println("每页显示值 " + page.getSize());
        System.out.println("一共多少页 " + page.getPages());
        System.out.println("一共多少数据 " + page.getTotal());
        System.out.println("数据 " + page.getRecords());

    }


}
