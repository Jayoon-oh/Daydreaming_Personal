package com.daydreaming.service;

import com.daydreaming.domain.Article;
import com.daydreaming.dto.AddArticleRequest;
import com.daydreaming.dto.UpdateArticleRequest;
import com.daydreaming.repository.BlogRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 붙거나 @NotNull 이 붙은 빌드 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() { // Article 에 저장되어 있는 모든 데이터 조회
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found" + id));
    }

    // 글 삭제 메서드
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    // 글 수정 메서드
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found" + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
