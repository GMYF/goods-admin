package com.light.springboot.core.controller.book;

import com.light.springboot.common.annotation.PassList;
import com.light.springboot.core.dao.BookMapper;
import com.light.springboot.core.domain.book.Book;
import com.light.springboot.util.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookMapper bookMapper;

    public BookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public ResponseResult<Book> putBook() {
        Book book = new Book();
        book.setName("java高并发");
        book.setCatagory("java");
        book.setNum("2");
        bookMapper.insert(book);
        return ResponseResult.success(book);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseResult<List<Book>> getAll() {
        return ResponseResult.success(bookMapper.selectList(null));
    }

    @PassList(value = "lisi,wangwu,zhangsan,maliu")
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseResult<String> checkAuth(@RequestParam("name") String name) {
        return ResponseResult.success("finish");
    }

}
