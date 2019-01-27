package com.dadadamarine.webservice.service;

import com.dadadamarine.webservice.domain.posts.PostsRepository;
import com.dadadamarine.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

}
