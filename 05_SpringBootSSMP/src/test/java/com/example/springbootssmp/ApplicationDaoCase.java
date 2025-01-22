package com.example.springbootssmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootssmp.dao.BookDao;
import com.example.springbootssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationDaoCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void getAll() {
        List<Book> books = bookDao.selectList(null);
        System.out.println("ApplicationDaoCase: getAll() ===========>> " + books);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("testName1");
        book.setType("testType1");
        book.setDescription("testDescription1");
        int count = bookDao.insert(book);
        System.out.println("ApplicationDaoCase: testSave(): count=" + count);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(11);
        book.setName("testName12");
        book.setType("testType12");
        book.setDescription("testDescription12");
        int count = bookDao.updateById(book);
        System.out.println("ApplicationDaoCase: testUpdate(): count=" + count);
    }

    @Test
    void testDelete() {
        int count = bookDao.deleteById(12);
        System.out.println("ApplicationDaoCase: testDelete(): count=" + count);
    }

    @Test
    void testQueryById() {
        Book book = bookDao.selectById(11);
        System.out.println("ApplicationDaoCase: testQueryById(): book=" + book);
    }

    @Test
    void testQueryPage() {
        // 注意，分页请求需要在sql尾部拼接条件，需要使用mp的拦截器, 详见MPConfig
        IPage<Book> page = new Page<>(1, 3);
        bookDao.selectPage(page, null);
        System.out.println("ApplicationDaoCase: testQueryPage(): current=" + page.getCurrent());
        System.out.println("ApplicationDaoCase: testQueryPage(): pages=" + page.getPages());
        System.out.println("ApplicationDaoCase: testQueryPage(): size=" + page.getSize());
        System.out.println("ApplicationDaoCase: testQueryPage(): total=" + page.getTotal());
        System.out.println("ApplicationDaoCase: testQueryPage(): records=" + page.getRecords());
    }

    @Test
    void testQueryBy() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        // 查询 name 字段为java的数据
        wrapper.eq("name", "java");
        Book book = bookDao.selectOne(wrapper);
        System.out.println("ApplicationDaoCase: testQueryBy(): book=" + book);
    }

    @Test
    void testQueryBy2() {
        String name = "java";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 条件成立时附加条件
        lambdaQueryWrapper.eq(name != null, Book::getName, name);
        Book book = bookDao.selectOne(lambdaQueryWrapper);
        System.out.println("ApplicationDaoCase: testQueryBy2(): book=" + book);
    }

}
