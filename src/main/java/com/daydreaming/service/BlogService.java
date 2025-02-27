package com.daydreaming.service;

import com.daydreaming.domain.Article;
import com.daydreaming.dto.AddArticleRequest;
import com.daydreaming.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final 붙거나 @NotNull 이 붙은 빌드 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
