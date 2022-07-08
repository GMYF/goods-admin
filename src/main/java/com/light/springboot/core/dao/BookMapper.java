package com.light.springboot.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.springboot.core.domain.book.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
