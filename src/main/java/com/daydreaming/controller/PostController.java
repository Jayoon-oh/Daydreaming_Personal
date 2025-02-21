package com.daydreaming.controller;

import com.daydreaming.request.PostCreate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

    @Slf4j
    @RestController
    @RequiredArgsConstructor
    public class
    PostController {

        @PostMapping("/posts")
        public String post(@RequestBody PostCreate params) {
            log.info("params={}", params.toString());
            return "Hello World";
        }
}

