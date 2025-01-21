package com.example.springbootdruid.dao;

import com.example.springbootdruid.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {

    @Select("select * from tsl_book")
    List<Book> getAll();

    @Select("select * from tsl_book where name = #{name}")
    Book getByName(String name);

}
