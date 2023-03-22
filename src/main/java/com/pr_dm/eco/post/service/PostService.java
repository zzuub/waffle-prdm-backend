package com.pr_dm.eco.post.service;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.User.repository.UserRepository;
import com.pr_dm.eco.post.dto.PostRequestDto;
import com.pr_dm.eco.post.dto.PostResponseDto;
import com.pr_dm.eco.post.entity.Post;
import com.pr_dm.eco.post.mapper.PostMapper;
import com.pr_dm.eco.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, Long userId) {
        Post post = this.postRepository.save(PostMapper.toPostEntity(requestDto));
        User user = userRepository.findByUserId(userId);
        return PostMapper.toPostResponseDto(post);
    }

    // TODO: limit, offset (pagination)
    @Transactional
    public Page<PostResponseDto> getPostList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postList = this.postRepository.findAll(pageable);
        return postList.map(PostMapper::toPostResponseDto);
    }

    @Transactional
    public PostResponseDto getPostById(Long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow();
        return PostMapper.toPostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto requestDto, Long userId) {
        Post post = this.postRepository.findById(postId).orElseThrow();
        User user = userRepository.findByUserId(userId);
        if (!requestDto.getTitle().isEmpty())
            post.setTitle(requestDto.getTitle());
        if (!requestDto.getText().isEmpty())
            post.setText(requestDto.getText());
        post.setModifyDate(LocalDateTime.now());
        Post updatedPost = this.postRepository.save(post);
        return PostMapper.toPostResponseDto(updatedPost);
    }

    // TODO: check if the user is the author of the post
    @Transactional
    public PostResponseDto deletePost(Long postId, Long userId) {
        Post post = this.postRepository.findById(postId).orElseThrow();
        User user = userRepository.findByUserId(userId);
        this.postRepository.delete(post);
        return PostMapper.toPostResponseDto(post);
    }

    @Transactional
    public List<PostResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    /*@Transactional(readOnly = true)
    public List<Post> findByCategory(PostCategory category){
        return postRepository.findByCategory(category);
    }*/
}
