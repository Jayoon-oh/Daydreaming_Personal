package com.daydreaming.controller;

import com.daydreaming.request.PostCreate;
import com.daydreaming.response.PostResponse;
import com.daydreaming.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor // @autowired 보다 권고. 이유 찾기
public class PostController {
// Controller -> Serivce 호출 -> Repository 호출 -> 최종적으로 넘어온 Json값은 post entity로 저장

        private final PostService postService;

        @PostMapping("/posts")
        public void post(@RequestBody @Valid PostCreate request) {
            postService.write(request);
    }

        // posts/{postId} -> 글 한개만 조회
        @GetMapping("/posts/{postId}")
        public PostResponse get(@PathVariable Long postId) {
            return postService.get(postId);
        }

}

