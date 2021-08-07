package com.example.sanchaek_backend.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor
public class BookResponse {
    private ArrayList<ResponseDocuments> documents;
    private Meta meta;

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
        private int sale_price;
        private String thumbnail;
        private String status;
    }

    @Data @NoArgsConstructor
    class Meta {
        private int totalCount;
        private int pageableCount;
        private boolean isEnd;
    }
}
