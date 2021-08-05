package com.example.sanchaek_backend.book;

import com.google.gson.JsonObject;
import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

@Service
public class BookService {

    private String serviceKey = "1e12bed8d420ee06e3d7ff3e16bb9247";
    private BookRepository repo;

    @Autowired
    public BookService(BookRepository repo) {

        this.repo = repo;
    }

    @Scheduled(cron = "0 18 14 * * *")
    public void requestBook() throws IOException {
        getBook("김영하");
    }

    private void getBook(String keyword) throws IOException {

        try {
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

            String data = response.toString();


            JSONParser parser = new JSONParser();
            Object obj = parser.parse(data);
            JSONObject jsonObj = (JSONObject) obj;

            String finalData = jsonObj.toString();

            BookResponse res = new Gson().fromJson(finalData, BookResponse.class);

            System.out.println("----res----");
            System.out.println(res);


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
