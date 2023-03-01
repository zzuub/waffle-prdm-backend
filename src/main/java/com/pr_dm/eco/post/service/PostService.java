package com.pr_dm.eco.post.service;

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

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    public final PostRepository postRepository;
    public PostResponseDto createPost(PostRequestDto req) {
        Post post = this.postRepository.save(PostMapper.toPostEntity(req));
        return PostMapper.toPostResponseDto(post);
    }

    // TODO: limit, offset (pagination)
    public Page<PostResponseDto> getPostList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postList = this.postRepository.findAll(pageable);
        return postList.map(PostMapper::toPostResponseDto);
    }

    public PostResponseDto getPostById(long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow();
        return PostMapper.toPostResponseDto(post);
    }

    public PostResponseDto updatePost(long postId, PostRequestDto req) {
        Post post = this.postRepository.findById(postId).orElseThrow();
        if (!req.getTitle().isEmpty())
            post.setTitle(req.getTitle());
        if (!req.getText().isEmpty())
            post.setText(req.getText());
        post.setModifyDate(LocalDateTime.now());
        Post updatedPost = this.postRepository.save(post);
        return PostMapper.toPostResponseDto(updatedPost);
    }

    // TODO: check if the user is the author of the post
    public PostResponseDto deletePost(long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow();
        this.postRepository.delete(post);
        return PostMapper.toPostResponseDto(post);
    }
}
