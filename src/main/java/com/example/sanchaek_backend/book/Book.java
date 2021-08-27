package com.example.sanchaek_backend.book;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Date datetime;
    private String authors;
    private String publisher;
    private String translators;
    private String price;
    private String salePrice;
    private String thumbnail;
    private String status;
    @JsonProperty(value = "isSaved")
    private boolean isSaved;
    @JsonProperty(value = "isRead")
    private boolean isRead;

    public Book(BookResponse.ResponseDocuments res) {

        this.title = res.getTitle();
        this.contents = res.getContents();
        this.url = res.getUrl();
        this.isbn = res.getIsbn();
        this.datetime = res.getDatetime();
        this.publisher = res.getPublisher();
        this.price = res.getPrice();
        this.salePrice = res.getSale_price();
        this.thumbnail = res.getThumbnail();
        this.status = res.getStatus();
    }
}
