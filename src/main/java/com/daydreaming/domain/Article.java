package com.daydreaming.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id" , updatable = false)
    private long id;

    @Column(name = "title" , nullable = false) // 'title' -> not null 컬럼과 매칭
    private String title;

    @Column(name = "content" , nullable = false)
    private String content;

    @Builder // 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 글 시간 확인
    @CreatedDate // 엔터티가 생성될 때 생성 시간 저장
    @Column(name= "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate // 엔터티가 수정될 때 수정 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
