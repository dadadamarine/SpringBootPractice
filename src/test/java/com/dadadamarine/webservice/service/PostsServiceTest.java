package com.dadadamarine.webservice.service;

import com.dadadamarine.webservice.domain.posts.Posts;
import com.dadadamarine.webservice.domain.posts.PostsRepository;
import com.dadadamarine.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsService postsService;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void service를_통해서_Dto가_posts테이블에_저장된다(){
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("dadadamarine@gmail.com")
                .content("테스트 내용")
                .title("테스트 타이틀")
                .build();

        postsService.save(dto);

        Posts posts= postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
    }

}