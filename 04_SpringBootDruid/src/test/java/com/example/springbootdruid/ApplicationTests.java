package com.example.springbootdruid;

import com.example.springbootdruid.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void getAll() {
        System.out.println("druid begin =====================> getAll()");
        System.out.println(bookDao.getAll());
        System.out.println("druid end =====================> getAll()");
    }

    @Test
    void getByName() {
        System.out.println("druid begin =====================> getByName()");
        System.out.println(bookDao.getByName("Java"));
        System.out.println("druid end =====================> getByName()");
    }

}
