package com.example.sanchaek_backend.user;

import com.example.sanchaek_backend.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserWishList {
    private int id;
    private List<Book> wishList;
}
