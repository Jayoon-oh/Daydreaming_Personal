package com.daydreaming.controller;

import com.daydreaming.request.PostCreate;
import com.daydreaming.response.PostResponse;
import com.daydreaming.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {


        private final PostService postService;

        // 새로운 게시글 저장하고 생성
        @PostMapping("/posts")
        public void post(@RequestBody @Valid PostCreate request) {
            postService.write(request);
        }

        // posts/{postId} -> 글 한개만 조회
        @GetMapping("/posts/{postId}")
        public PostResponse get(@PathVariable Long postId) {
            return postService.get(postId);
        }

        // 여러글 조회 API (게시글 목록 가져올때)
        @GetMapping("/posts")
        public List<PostResponse> getList() {
            return postService.getList();
        }

}

