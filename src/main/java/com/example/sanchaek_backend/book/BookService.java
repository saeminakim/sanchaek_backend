package com.example.sanchaek_backend.book;

import com.example.sanchaek_backend.user.WishBookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@Service
@Slf4j //로그 찍는거
public class BookService {

    private String serviceKey = "1e12bed8d420ee06e3d7ff3e16bb9247";
//    private WishBookRepository repo;

//    @Autowired
//    public BookService(WishBookRepository repo) {
//
//        this.repo = repo;
//    }

    public ArrayList<Book> getBook(String keyword) throws IOException {

        ArrayList<Book> books = new ArrayList<Book>();

        boolean isEnd;
        int page = 1;


        while (true) {

            try {

                String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");


                StringBuilder builder = new StringBuilder();
                builder.append("https://dapi.kakao.com/v3/search/book")
                        .append("?query=")
                        .append(encodedKeyword)
                        .append("&size=50")
                        .append("&page=")
                        .append(page);

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

                ObjectMapper objectMapper = new ObjectMapper();
                BookResponse res = objectMapper.readValue(data, BookResponse.class);

                isEnd = res.getMeta().isEnd();


                for (BookResponse.ResponseDocuments item : res.getDocuments()) {
                    Book book = new Book(item);

                    book.setAuthors(mergeAuthors(item));

                    if (item.getTranslators().length > 0) {
                        book.setTranslators(mergeTranslators(item));
                    }

                    book.setPrice(book.getPrice().toString());
                    book.setSalePrice(book.getSalePrice().toString());

                    book.setSaved(false);
                    book.setRead(false);

                    books.add(book);
                }

                page += 1;

                if(isEnd) {
                    break;
                }


            } catch (IOException e) {
                log.warn("API 호출 에러", e);
            }

        }

        return books;

    }

    private String mergeAuthors(BookResponse.ResponseDocuments item) {
        String[] authors = item.getAuthors();
        StringBuilder allAuthors = new StringBuilder();

        for (String author : authors) {
            allAuthors.append(author).append(" ");
        }
        return allAuthors.toString();
    }

    private String mergeTranslators(BookResponse.ResponseDocuments item) {
        String[] translators = item.getTranslators();
        StringBuilder allTranslators = new StringBuilder();

        for (String translator : translators) {
            allTranslators.append(translator).append(" ");
        }
        return allTranslators.toString();
    }
}
