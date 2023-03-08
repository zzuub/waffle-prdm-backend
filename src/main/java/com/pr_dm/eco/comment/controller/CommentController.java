package com.pr_dm.eco.comment.controller;

import com.pr_dm.eco.comment.dto.CommentRequestDto;
import com.pr_dm.eco.comment.dto.CommentResponseDto;
import com.pr_dm.eco.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // TODO : authorization header -> get user id
    @PutMapping("/api/v1/post/{postId}/comment")
    @ResponseBody
    public CommentResponseDto createComment(@PathVariable long postId, @RequestBody CommentRequestDto req, @RequestHeader String authorization) {
        return commentService.createComment(postId, req);
    }

    @GetMapping("/api/v1/post/{postId}/comment/list")
    @ResponseBody
    public Page<CommentResponseDto> getCommentLst(@PathVariable long postId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return commentService.getCommentList(postId, page, size);
    }

    @GetMapping("/api/v1/post/{postId}/comment/{commentId}")
    @ResponseBody
    public CommentResponseDto getComment(@PathVariable long postId, @PathVariable long commentId) {
        return commentService.getCommentById(postId, commentId);
    }

    // TODO : validate authorization header
    @PostMapping("/api/v1/post/{postId}/comment/{commentId}")
    @ResponseBody
    public CommentResponseDto updateComment(@PathVariable long postId, @PathVariable long commentId, @RequestBody CommentRequestDto req, @RequestHeader String authorization) {
        return commentService.updateComment(postId, commentId, req);
    }

    // TODO : validate authorization header
    @DeleteMapping("/api/v1/post/{postId}/comment/{commentId}")
    @ResponseBody
    public CommentResponseDto deleteComment(@PathVariable long postId, @PathVariable long commentId, @RequestHeader String authorization) {
        return commentService.deleteComment(postId, commentId);
    }

}
