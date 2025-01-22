package com.example.springbootssmp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootssmp.domain.Book;
import com.example.springbootssmp.service.impl.BookServiceDefaultImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationServiceCase {

    @Autowired
    private BookServiceDefaultImpl service;

    @Test
    void testQueryAll() {
        List<Book> books = service.queryAll();
        System.out.println("ApplicationServiceCase: testQueryAll(): books=" + books);
    }

    @Test
    void testQueryById() {
        Book book = service.queryById(2);
        System.out.println("ApplicationServiceCase: testQueryById(): book=" + book);
    }

    @Test
    void testAdd() {
        Book book = new Book();
        book.setName("serviceName1");
        book.setType("serviceType1");
        book.setDescription("serviceDescription1");
        boolean result = service.addBook(book);
        System.out.println("ApplicationServiceCase: testAdd(): result=" + result);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(11);
        book.setName("serviceName12");
        book.setType("serviceType13");
        book.setDescription("serviceDescription14");
        boolean result = service.updateBook(book);
        System.out.println("ApplicationServiceCase: testUpdate(): result=" + result);
    }

    @Test
    void testDelete() {
        boolean result = service.deleteBookById(13);
        System.out.println("ApplicationServiceCase: testDelete(): result=" + result);
    }

    @Test
    void testQueryPage() {
        IPage<Book> page = service.queryPage(1, 5);
        System.out.println("ApplicationServiceCase: testQueryPage(): total=" + page.getTotal());
        System.out.println("ApplicationServiceCase: testQueryPage(): pages=" + page.getPages());
        System.out.println("ApplicationServiceCase: testQueryPage(): current=" + page.getCurrent());
        System.out.println("ApplicationServiceCase: testQueryPage(): size=" + page.getSize());
        System.out.println("ApplicationServiceCase: testQueryPage(): records=" + page.getRecords());
    }

}
