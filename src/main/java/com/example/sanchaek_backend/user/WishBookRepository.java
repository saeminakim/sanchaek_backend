package com.example.sanchaek_backend.user;

import com.example.sanchaek_backend.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishBookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllBySaved(boolean isSaved);
}
