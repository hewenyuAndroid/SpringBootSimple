package com.example.springbootssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootssmp.dao.BookDao;
import com.example.springbootssmp.domain.Book;
import com.example.springbootssmp.service.IAutoBookService;
import org.springframework.stereotype.Service;

@Service
public class AutoBookServiceImpl extends ServiceImpl<BookDao, Book> implements IAutoBookService {

    // 内部依然支持自定义查询

}
