package com.example.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootmybatisplus.dao.BookDao;
import com.example.springbootmybatisplus.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void getAll() {
        System.out.println("mybatis-plus begin ==============================> getAll()");
        System.out.println(bookDao.selectList(null));
        System.out.println("mybatis-plus end ==============================> getAll()");
    }

    @Test
    void getById() {
        System.out.println("mybatis-plus begin ==============================> getById()");
        System.out.println(bookDao.selectById(3));
        System.out.println("mybatis-plus end ==============================> getById()");
    }

    @Test
    void getByName() {
        System.out.println("mybatis-plus begin ==============================> getByName()");
        // 查询 name 为 Java 的数据
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Java");
        System.out.println(bookDao.selectOne(wrapper));
        System.out.println("mybatis-plus end ==============================> getByName()");
    }


}
