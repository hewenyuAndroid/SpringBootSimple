package com.example.springbootssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootssmp.domain.Book;
import com.example.springbootssmp.service.impl.AutoBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private AutoBookServiceImpl bookService;

    @GetMapping
    public List<Book> queryAll() {
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable int id) {
        return bookService.removeById(id);
    }

    @GetMapping("{pageNo}/{pageSize}")
    public IPage<Book> pageQuery(@PathVariable int pageNo, @PathVariable int pageSize) {
        IPage<Book> page = new Page<>(pageNo, pageSize);
        return bookService.page(page);
    }

}
