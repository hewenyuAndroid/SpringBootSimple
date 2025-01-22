package com.example.springbootssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootssmp.dao.BookDao;
import com.example.springbootssmp.domain.Book;
import com.example.springbootssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceDefaultImpl implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> queryAll() {
        return bookDao.selectList(null);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean deleteBookById(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book queryById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public IPage<Book> queryPage(int pageIndex, int pageCount) {
        return bookDao.selectPage(new Page<>(pageIndex, pageCount), null);
    }

}
