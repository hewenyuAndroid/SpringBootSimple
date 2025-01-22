package com.example.springbootssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootssmp.domain.Book;

import java.util.List;


public interface IBookService {

    List<Book> queryAll();

    boolean addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBookById(Integer id);

    Book queryById(Integer id);

    IPage<Book> queryPage(int pageIndex, int pageCount);

}
