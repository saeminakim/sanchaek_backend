package com.example.sanchaek_backend.user;

import com.example.sanchaek_backend.book.Book;
import com.example.sanchaek_backend.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserWishListController {
    private WishBookRepository repo;

    @Autowired
    UserWishListController(WishBookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/wishlist")
    public List<Book> getWishList() {
        return repo.findAll();
    }

    @PostMapping("/wishlist")
    public void AddWishList(@RequestBody Book book) {
//        book.setIsSaved(true);
//        book.setIsRead(false);
        System.out.println(book.toString());
        repo.save(book);
    }
}
