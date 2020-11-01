package com.webservice.rentalSpace.service.posts;

import com.webservice.rentalSpace.domain.posts.Posts;
import com.webservice.rentalSpace.domain.posts.PostsRepository;
import com.webservice.rentalSpace.web.dto.PostsResponseDto;
import com.webservice.rentalSpace.web.dto.PostsSaveRequestDto;
import com.webservice.rentalSpace.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //save
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //update
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("There is no post. (id = "+id)
        );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    //조회
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("There is no post. (id= "+id)
        );

        return new PostsResponseDto(entity);
    }
}
