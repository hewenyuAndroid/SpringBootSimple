package com.example.springbootssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
