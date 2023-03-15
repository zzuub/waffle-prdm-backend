package com.pr_dm.eco.post.controller;

import com.pr_dm.eco.post.dto.PostRequestDto;
import com.pr_dm.eco.post.dto.PostResponseDto;
import com.pr_dm.eco.post.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "게시글")
public class PostController {

    private final PostService postService;

    // TODO : authorization header -> get user id
    @ApiOperation(value = "create post", notes = "create post")
    @PutMapping("/api/v1/post")
    @ResponseBody
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, @RequestHeader String authorization) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/v1/post/list")
    @ResponseBody
    public Page<PostResponseDto> getPostLst(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return postService.getPostList(page, size);
    }

    @GetMapping("/api/v1/post/{postId}")
    @ResponseBody
    public PostResponseDto getPost(@PathVariable("postId") long postId) {
        return postService.getPostById(postId);
    }

    // TODO : validate authorization header
    @PostMapping("/api/v1/post/{postId}")
    @ResponseBody
    public PostResponseDto updatePost(@PathVariable("postId") long postId, @RequestBody PostRequestDto requestDto, @RequestHeader String authorization) {
        return postService.updatePost(postId, requestDto);
    }

    // TODO : validate authorization header
    @DeleteMapping("/api/v1/post/{postId}")
    @ResponseBody
    public PostResponseDto deletePost(@PathVariable("postId") long postId, @RequestHeader String authorization) {
        return postService.deletePost(postId);
    }

}
