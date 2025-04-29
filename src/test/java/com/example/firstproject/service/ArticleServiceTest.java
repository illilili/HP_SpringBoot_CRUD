package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링부트와 연동 되어 테스팅
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a =  new Article(1L, "가가가가", "1111");
        Article b =  new Article(2L, "나나나나", "2222");
        Article c =  new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();


        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    // 존재 id 입력
    void show_성공() {
        // 예상
        Long id = 1L;
        Article expected =  new Article(id, "가가가가", "1111");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    // 존재하지 않는 id
    void show_실패() {
        // 예상
        Long id = -1L;
        Article expected =  null;

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article);

    }

    @Test
    @Transactional // 데이터 변경 가능성 있을 떄
    void create_성공() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());

    }
    @Test
    @Transactional
    // id 포함 dto
    void create_실패() {
        // 예상

        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);

    }
햣
}