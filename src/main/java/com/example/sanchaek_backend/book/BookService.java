package com.example.sanchaek_backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class BookService {

    private String serviceKey = "1e12bed8d420ee06e3d7ff3e16bb9247";
    private BookRepository repo;

    @Autowired
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    private void getBook(String keyword) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("https://dapi.kakao.com/v3/search/book");
        builder.append("?query=" + keyword);

        URL url = new URL(builder.toString());

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization", "KakaoAK " + serviceKey);

        byte[] result = con.getInputStream().read();

    }
}
