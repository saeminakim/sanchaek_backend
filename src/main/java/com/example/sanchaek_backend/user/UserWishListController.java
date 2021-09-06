package com.example.sanchaek_backend.user;

import com.example.sanchaek_backend.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserWishListController {
    private WishBookRepository bookRepo;

    @Autowired
    UserWishListController(WishBookRepository repo) {
        this.bookRepo = repo;
    }

    @GetMapping("/wishlist")
    public List<Book> getWishList() {
        return bookRepo.findAll();
    }

    @PostMapping("/wishlist")
    public void AddWishList(@RequestBody Book book) {
        book.setSaved(true);
        bookRepo.save(book);
    }
}
