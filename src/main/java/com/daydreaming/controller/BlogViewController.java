package com.daydreaming.controller;

import com.daydreaming.domain.Article;
import com.daydreaming.dto.ArticleListViewResponse;
import com.daydreaming.dto.ArticleViewResponse;
import com.daydreaming.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    // 게시글 리스트 보여주기
    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList"; // Show 'articleList.html'
    }

    // 게시글 상세보기
    @GetMapping("/articles/{id}")
    public String getArticles(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }


}
