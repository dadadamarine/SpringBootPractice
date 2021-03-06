package com.dadadamarine.webservice.web;

import com.dadadamarine.webservice.domain.posts.PostsRepository;
import com.dadadamarine.webservice.dto.posts.PostsSaveRequestDto;
import com.dadadamarine.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public String savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsService.save(dto);
        return "{\"msg\":\"success\"}";
    }
}
