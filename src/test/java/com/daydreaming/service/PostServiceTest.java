package com.daydreaming.service;

import com.daydreaming.domain.Post;
import com.daydreaming.repository.PostRepository;
import com.daydreaming.request.PostCreate;
import com.daydreaming.response.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void clean() {
        postRepository.deleteAll(); // 메서드 실행마다 repository비워서 환경관리
    }

    @Test
    @DisplayName("글 작성")
    void test1()
    {
        // given
        PostCreate postCreate = PostCreate.builder()
                .title("제목입니다")
                .content("내용입니다")
                .build();

        // when
        postService.write(postCreate); //글 작성

        // then
        assertEquals(1L, postRepository.count()); //검증
        Post post = postRepository.findAll().get(0);
        assertEquals("제목입니다", post.getTitle());
        assertEquals("내용입니다", post.getContent());
    }
    @Test
    @DisplayName("글 1개 조회")
    void test2() {
        //given
        Post requestPost = Post.builder()
                .title("foo")
                .content("bar")
                .build();
        postRepository.save(requestPost);

        // when
        PostResponse response = postService.get(requestPost.getId());

        // then
        assertNotNull(response);
        assertEquals(1L , postRepository.count());
        assertEquals("foo", response.getTitle());
        assertEquals("bar", response.getContent());
    }

    @Test
    @DisplayName("글 여러개 조회")
    void test3() {
        //given
        postRepository.saveAll(List.of(
        Post.builder()
                .title("foo1")
                .content("bar1")
                .build(),
        Post.builder()
                .title("foo2")
                .content("bar2")
                .build()
        ));

        // when
        List<PostResponse> posts = postService.getList();

        // then
        assertEquals(2L , posts.size());
    }

}