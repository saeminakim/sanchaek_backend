package com.example.sanchaek_backend.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor
public class BookResponse {
    private ArrayList<ResponseDocuments> documents;
    private Meta meta;

    @Data
    @NoArgsConstructor
    static class ResponseDocuments {
        private String title;
        private String contents;
        private String url;
        private String isbn;

        @JsonDeserialize(using = DateHandler.class) //jackson
        private Date datetime;
        private String[] authors;
        private String publisher;
        private String[] translators;
        private String price;
        @JsonProperty("sale_price")
        private String salePrice;
        private String thumbnail;
        private String status;
    }

    @Data @NoArgsConstructor
    static class Meta {
        @JsonProperty("total_count")
        private int totalCount;
        @JsonProperty("pageable_count")
        private int pageableCount;
        @JsonProperty("is_end")
        private boolean isEnd;
    }
}
