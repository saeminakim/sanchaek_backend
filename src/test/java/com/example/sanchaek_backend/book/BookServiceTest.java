package com.example.sanchaek_backend.book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookServiceTest {

//    @Autowired
//    private BookService bookService;

//    @Autowired
//    private BookRepository repo;

    @Test
    @DisplayName("테스트")
    @Transactional
    public void getBookTest() throws IOException {
        //givem
//         bookService = new BookService();
         //
//         bookService.getBook("김영하");
//         assertThat("").
     }
}