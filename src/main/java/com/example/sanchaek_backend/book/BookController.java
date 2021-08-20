package com.example.sanchaek_backend.book;

import com.example.sanchaek_backend.user.WishBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class BookController {

    private BookService service;

    @Autowired
    BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(value = "/books")
    public ArrayList<Book> getBookList(@RequestParam("query") String keyword) throws IOException {
        ArrayList<Book> books = service.getBook(keyword);
        return books;
    }
}
