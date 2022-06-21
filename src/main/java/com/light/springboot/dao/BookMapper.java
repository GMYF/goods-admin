package com.light.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.springboot.domain.book.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
