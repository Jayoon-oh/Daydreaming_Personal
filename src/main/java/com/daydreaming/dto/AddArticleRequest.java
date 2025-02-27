package com.daydreaming.dto;

import com.daydreaming.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

     public Article toEntity() { // 글 추가시 저장할 엔터티로 변환하는 용도
         return Article.builder()
                 .title(title)
                 .content(content)
                 .build();
     }
}
