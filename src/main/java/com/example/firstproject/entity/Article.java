package com.example.firstproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //DB가 인식
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
