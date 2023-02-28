package com.pr_dm.eco.post.controller;

import com.pr_dm.eco.post.dto.PostRequestDto;
import com.pr_dm.eco.post.dto.PostResponseDto;
import com.pr_dm.eco.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // TODO : authorization header -> get user id
    @PutMapping("/")
    @ResponseBody
    public PostResponseDto createPost(@RequestBody PostRequestDto req, @RequestHeader String authorization) {
        return this.postService.createPost(req);
    }

    @GetMapping("/list")
    @ResponseBody
    public Page<PostResponseDto> getPostLst(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return this.postService.getPostList(page, size);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PostResponseDto getPost(@PathVariable("id") long id) {
        return this.postService.getPostById(id);
    }

    // TODO : validate authorization header
    @PostMapping("/{id}")
    @ResponseBody
    public PostResponseDto updatePost(@PathVariable("id") long id, @RequestBody PostRequestDto req, @RequestHeader String authorization) {
        return this.postService.updatePost(id, req);
    }

    // TODO : validate authorization header
    @DeleteMapping("/{id}")
    @ResponseBody
    public PostResponseDto deletePost(@PathVariable("id") long id, @RequestHeader String authorization) {
        return this.postService.deletePost(id);
    }

}
