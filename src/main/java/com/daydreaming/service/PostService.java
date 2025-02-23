package com.daydreaming.service;

import com.daydreaming.domain.Post;
import com.daydreaming.repository.PostRepository;
import com.daydreaming.request.PostCreate;
import com.daydreaming.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) { // jsonBody 에서 꺼내와서 생성자 형태로 넘겨주고 있음.
        Post post = Post.builder()
                    .title(postCreate.getTitle())
                    .content(postCreate.getContent())
                    .build();

        postRepository.save(post);
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id) // warning
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 글입니다."));


        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public List<PostResponse> getList() {
        return postRepository.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

}
