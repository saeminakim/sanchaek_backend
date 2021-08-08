package com.example.sanchaek_backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class BookController {

//    private BookRepository repo;
//    private BookService service;
//
//    @Autowired
//    BookController(BookRepository repo, BookService service) {
//        this.repo = repo;
//        this.service = service;
//    }
//
//    @GetMapping(value = "/books")
//    public Page<Book> getBookList(@RequestParam("query") String keyword) throws IOException {
//        service.getBook(keyword);
//    }
}
