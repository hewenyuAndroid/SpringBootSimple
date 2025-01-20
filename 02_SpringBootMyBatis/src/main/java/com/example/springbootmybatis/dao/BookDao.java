package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {

    @Select("select * from tsl_book")
    List<BookDTO> getAll();

    @Select("select * from tsl_book where name = #{name}")
    BookDTO getByName(String name);

}
