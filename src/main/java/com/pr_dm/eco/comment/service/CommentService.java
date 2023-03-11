package com.pr_dm.eco.comment.service;

import com.pr_dm.eco.comment.dto.CommentRequestDto;
import com.pr_dm.eco.comment.dto.CommentResponseDto;
import com.pr_dm.eco.comment.entity.Comment;
import com.pr_dm.eco.comment.mapper.CommentMapper;
import com.pr_dm.eco.comment.repository.CommentRepository;
import com.pr_dm.eco.post.entity.Post;
import com.pr_dm.eco.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    public final CommentRepository commentRepository;
    public final PostRepository postRepository;
    public CommentResponseDto createComment(long postId, CommentRequestDto req) {
        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = CommentMapper.toCommentEntity(req);
        comment.setPost(post);
        Comment queryResult = commentRepository.save(comment);
        return CommentMapper.toCommentResponseDto(queryResult);
    }

    public Page<CommentResponseDto> getCommentList(long postId, int page, int size) {
        Post post = postRepository.findById(postId).orElseThrow();
        Pageable pageable = PageRequest.of(page, size);
        Page<Comment> queryResult = commentRepository.findAllByPost(post, pageable);
        return queryResult.map(CommentMapper::toCommentResponseDto);
    }

    public CommentResponseDto getCommentById(long postId, long commentId) {
        postRepository.findByPostId(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        return CommentMapper.toCommentResponseDto(comment);
    }

    public CommentResponseDto updateComment(long postId, long commentId, CommentRequestDto req) {
        postRepository.findByPostId(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (!req.getText().isEmpty())
            comment.setText(req.getText());
        Comment queryResult = commentRepository.save(comment);
        return CommentMapper.toCommentResponseDto(queryResult);
    }

    // TODO: check if the user is the author of the post
    public CommentResponseDto deleteComment(long postId, long commentId) {
        postRepository.findByPostId(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(comment);
        return CommentMapper.toCommentResponseDto(comment);
    }
}
