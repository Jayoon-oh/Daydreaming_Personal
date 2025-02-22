package com.daydreaming.controller;

import com.daydreaming.domain.Post;
import com.daydreaming.request.PostCreate;
import com.daydreaming.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

