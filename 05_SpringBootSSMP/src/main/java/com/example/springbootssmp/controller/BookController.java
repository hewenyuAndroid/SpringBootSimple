package com.example.springbootssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootssmp.controller.utils.R;
import com.example.springbootssmp.domain.Book;
import com.example.springbootssmp.service.impl.AutoBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private AutoBookServiceImpl bookService;

    @GetMapping
    public R queryAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        boolean result = bookService.save(book);
        return new R(result, result ? "success" : "failure");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        boolean result = bookService.updateById(book);
        return new R(result, result ? "success" : "failure");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable int id) {
        Book book = bookService.getById(id);
        return new R(book != null, book);
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable int id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("{pageNo}/{pageSize}")
    public R pageQuery(@PathVariable int pageNo, @PathVariable int pageSize) {
        IPage<Book> page = new Page<>(pageNo, pageSize);
        bookService.page(page);
        return new R(true, page);
    }

}
