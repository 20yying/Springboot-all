package com.yy.dao.impl;

import com.yy.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("booksave");
    }
}
