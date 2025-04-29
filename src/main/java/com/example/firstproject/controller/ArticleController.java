package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    public static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired // 스프링부트가 생성해둔 객체 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        // System.out.println(form.toString());  // 실제 서버에서는 사용X 로깅으로 대체
        log.info(form.toString()); // 데이터가 로깅을 통해 출력

        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1. id로 데이터를 가져옴
        Article articleEntity =  articleRepository.findById(id).orElse(null);

        // 2. 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {

        // 1. 모든 아티클을 가져옴
        List<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 아티클 묶음 뷰로 전달
        model.addAttribute("articleList", articleEntityList);

        // 3. 뷰 페이지
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);

        return "articles/edit";

    }

    @PostMapping("articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());

        // 1. DTO를 엔티티로
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());


        // 2. 엔티티 db 저장
        // 기존 데이터 가져오기
        Article target =  articleRepository.findById(articleEntity.getId()).orElse(null);

        // 수정
        if (target != null) {
            articleRepository.save(articleEntity);
        }

        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제요청");

        // 1. 삭제 대상 가져옴
        Article target =  articleRepository.findById(id).orElse(null);

        // 2. 삭제
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료");
        }

        // 3. 리다이렉트
        return "redirect:/articles";

    }


}