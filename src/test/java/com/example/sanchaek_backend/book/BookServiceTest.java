package com.example.sanchaek_backend.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository repo;

    @Test
    public void getBookTest() throws IOException {
        //givem
         bookService = new BookService();
         //
         bookService.getBook("김영하");
//         assertThat("").
     }
}