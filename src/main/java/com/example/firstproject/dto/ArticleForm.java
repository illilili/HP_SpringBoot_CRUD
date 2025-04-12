package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // lombok으로 리펙토링
@ToString
public class ArticleForm {

    private String title;
    private String content;

    public Article toEntity(){
        return new Article(null, title, content);
    }


}


