package com.pr_dm.eco.post.controller;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.config.oauth.LoginUser;
import com.pr_dm.eco.post.dto.PostRequestDto;
import com.pr_dm.eco.post.dto.PostResponseDto;
import com.pr_dm.eco.post.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Api(tags = "게시글")
public class PostController {

    private final PostService postService;


    // TODO : authorization header -> get user id
    @ApiOperation(value = "create post", notes = "create post")
    @PostMapping("/api/v1/post")
    @ResponseBody
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto,
                                      @LoginUser User user) {
        return postService.createPost(requestDto, user.getUserId());
    }

    @GetMapping("/api/v1/post/list")
    @ResponseBody
    public Page<PostResponseDto> getPostList(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "10") int size) {
        return postService.getPostList(page, size);
    }

    @GetMapping("/api/v1/post/{postId}")
    @ResponseBody
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    // TODO : validate authorization header
    @PutMapping("/api/v1/post/{postId}")
    @ResponseBody
    public PostResponseDto updatePost(@PathVariable Long postId,
                                      @RequestBody PostRequestDto requestDto,
                                      @LoginUser User user) {
        return postService.updatePost(postId, requestDto, user.getUserId());
    }

    // TODO : validate authorization header
    @DeleteMapping("/api/v1/post/{postId}")
    @ResponseBody
    public PostResponseDto deletePost(@PathVariable Long postId,
                                      @LoginUser User user) {
        return postService.deletePost(postId, user.getUserId());
    }

    /*@GetMapping("/api/v1/category")
    public PostResponseDto findByCategory(@PathVariable PostCategory category){
        return postService.findByCategory(category);
    }*/

}
