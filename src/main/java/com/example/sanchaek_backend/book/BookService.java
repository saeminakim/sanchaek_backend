package com.example.sanchaek_backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class BookService {

    private String serviceKey = "1e12bed8d420ee06e3d7ff3e16bb9247";
    private BookRepository repo;

    public BookService() {

    }

    @Autowired
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    protected void getBook(String keyword) throws IOException {

        try {
            keyword = "김영하";
            StringBuilder builder = new StringBuilder();
            builder.append("https://dapi.kakao.com/v3/search/book");
            builder.append("?query=" + keyword);

            URL url = new URL(builder.toString());

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "KakaoAK " + serviceKey);
            int responseCode = con.getResponseCode();

            BufferedReader br;

            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }

            br.close();
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
