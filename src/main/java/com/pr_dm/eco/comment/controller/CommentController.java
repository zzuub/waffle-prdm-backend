package com.pr_dm.eco.comment.controller;

import com.pr_dm.eco.User.dto.UserDto;
import com.pr_dm.eco.comment.dto.CommentRequestDto;
import com.pr_dm.eco.comment.dto.CommentResponseDto;
import com.pr_dm.eco.comment.service.CommentService;
import com.pr_dm.eco.config.oauth.LoginUser;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequiredArgsConstructor
@Api(tags = "댓글")
public class CommentController {
    private final CommentService commentService;

    // TODO : authorization header -> get user id
    @PostMapping("/api/v1/post/{postId}/comment")
    @ResponseBody
    public CommentResponseDto createComment(@ApiIgnore @LoginUser UserDto user,
                                            @PathVariable Long postId,
                                            @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(user.getUserId(), postId, commentRequestDto);
    }

    @GetMapping("/api/v1/post/{postId}/comment/list")
    @ResponseBody
    public Page<CommentResponseDto> getCommentLst(@PathVariable Long postId,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        return commentService.getCommentList(postId, page, size);
    }

    @GetMapping("/api/v1/post/{postId}/comment/{commentId}")
    @ResponseBody
    public CommentResponseDto getComment(@PathVariable Long postId,
                                         @PathVariable Long commentId) {
        return commentService.getCommentById(postId, commentId);
    }

    // TODO : validate authorization header
    @PutMapping("/api/v1/post/{postId}/comment/{commentId}")
    @ResponseBody
    public CommentResponseDto updateComment(@PathVariable Long postId,
                                            @PathVariable Long commentId,
                                            @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(postId, commentId, commentRequestDto);
    }

    // TODO : validate authorization header
    @DeleteMapping("/api/v1/post/{postId}/comment/{commentId}")
    @ResponseBody
    public CommentResponseDto deleteComment(@PathVariable Long postId,
                                            @PathVariable Long commentId) {
        return commentService.deleteComment(postId, commentId);
    }

}
