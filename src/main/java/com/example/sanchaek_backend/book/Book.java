package com.example.sanchaek_backend.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String contents;
    private String url;
    private String isbn;
//    private Date dateTime;
    private String authors;
    private String publisher;
    private String translators;
    private int price;
    private int salePrice;
    private String thumbnail;
    private String status;
    private boolean isRead;

    public Book(BookResponse.ResponseDocuments res) {

        this.title = res.getTitle();
        this.contents = res.getContents();
        this.url = res.getUrl();
        this.isbn = res.getIsbn();
//        this.dateTime = res.getDateTime();
        this.publisher = res.getPublisher();
        this.price = res.getPrice();
        this.salePrice = res.getSale_price();
        this.thumbnail = res.getThumbnail();
        this.status = res.getStatus();
    }
}
