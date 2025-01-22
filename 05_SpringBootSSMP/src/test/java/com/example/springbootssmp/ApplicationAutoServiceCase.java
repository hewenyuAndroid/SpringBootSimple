package com.example.springbootssmp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootssmp.domain.Book;
import com.example.springbootssmp.service.impl.AutoBookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationAutoServiceCase {

    @Autowired
    private AutoBookServiceImpl service;

    @Test
    void testQueryAll() {
        List<Book> books = service.list();
        System.out.println("ApplicationAutoServiceCase: testQueryAll(): books=" + books);
    }

    @Test
    void testQueryById() {
        Book book = service.getById(2);
        System.out.println("ApplicationAutoServiceCase: testQueryById(): book=" + book);
    }

    @Test
    void testAdd() {
        Book book = new Book();
        book.setName("serviceName133");
        book.setType("serviceType133");
        book.setDescription("serviceDescription133");
        boolean result = service.save(book);
        System.out.println("ApplicationAutoServiceCase: testAdd(): result=" + result);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(11);
        book.setName("serviceName12aa");
        book.setType("serviceType13bb");
        book.setDescription("serviceDescription14cc");
        boolean result = service.updateById(book);
        System.out.println("ApplicationAutoServiceCase: testUpdate(): result=" + result);
    }

    @Test
    void testDelete() {
        boolean result = service.removeById(14);
        System.out.println("ApplicationAutoServiceCase: testDelete(): result=" + result);
    }

    @Test
    void testQueryPage() {
        IPage<Book> page = new Page<>(1, 3);
        service.page(page);
        System.out.println("ApplicationAutoServiceCase: testQueryPage(): total=" + page.getTotal());
        System.out.println("ApplicationAutoServiceCase: testQueryPage(): pages=" + page.getPages());
        System.out.println("ApplicationAutoServiceCase: testQueryPage(): current=" + page.getCurrent());
        System.out.println("ApplicationAutoServiceCase: testQueryPage(): size=" + page.getSize());
        System.out.println("ApplicationAutoServiceCase: testQueryPage(): records=" + page.getRecords());
    }

}
