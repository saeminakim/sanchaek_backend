package com.example.sanchaek_backend.book;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;

@Service
public class BookService {

    private String serviceKey = "1e12bed8d420ee06e3d7ff3e16bb9247";
    private BookRepository repo;

    @Autowired
    public BookService(BookRepository repo) {

        this.repo = repo;
    }

    @Scheduled(cron = "0 19 23 * * *")
    public void requestBook() throws IOException {
        getBook("김영하");
    }

    private void getBook(String keyword) throws IOException {

        try {

            String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");


            StringBuilder builder = new StringBuilder();
            builder.append("https://dapi.kakao.com/v3/search/book")
                    .append("?query=")
                    .append(encodedKeyword);

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

            String data = response.toString();

            System.out.println("data");
            System.out.println(data);

            BookResponse res = new Gson().fromJson(data, BookResponse.class);

            System.out.println("res");
            System.out.println(res);



//            for(BookResponse.ResponseDocuments item : res.getDocuments()) {
//                Book book = new Book(item);
//
//                System.out.println(book);
//
//                String authors = book.getAuthors();
////                System.out.println("authors");
////                System.out.println(authors);
//
//            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
