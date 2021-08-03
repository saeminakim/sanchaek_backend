package com.example.sanchaek_backend.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor
public class BookResponse {
    private List<ResponseDocuments> item;

    @Data
    @NoArgsConstructor
    class ResponseDocuments {
        private String title;
        private String contents;
        private String url;
        private String isbn;
        private Date dateTime;
        private String[] authors;
        private String publisher;
        private String[] translators;
        private int price;
        private int salePrice;
        private String thumbnail;
        private String status;
    }
}
