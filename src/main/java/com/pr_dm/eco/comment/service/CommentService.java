package com.pr_dm.eco.comment.service;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.User.repository.UserRepository;
import com.pr_dm.eco.comment.dto.CommentRequestDto;
import com.pr_dm.eco.comment.dto.CommentResponseDto;
import com.pr_dm.eco.comment.entity.Comment;
import com.pr_dm.eco.comment.mapper.CommentMapper;
import com.pr_dm.eco.comment.repository.CommentRepository;
import com.pr_dm.eco.post.entity.Post;
import com.pr_dm.eco.post.repository.PostRepository;
import com.pr_dm.eco.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostService postService;


    @Transactional
    public CommentResponseDto createComment(Long userId, Long postId, CommentRequestDto commentRequestDto) {
        Optional<User> user = userRepository.findById(userId);
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = CommentMapper.toCommentEntity(commentRequestDto);
        comment.setPost(post);
        comment.setUser(user.get());
        Comment queryResult = commentRepository.save(comment);

        return CommentMapper.toCommentResponseDto(queryResult);
    }


    public Page<CommentResponseDto> getCommentList(Long postId, int page, int size) {
        Post post = postRepository.findById(postId).orElseThrow();
        Pageable pageable = PageRequest.of(page, size);
        Page<Comment> queryResult = commentRepository.findAllByPost(post, pageable);

        return queryResult.map(CommentMapper::toCommentResponseDto);
    }


    public CommentResponseDto getCommentById(Long postId, Long commentId) {
        postRepository.findById(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        return CommentMapper.toCommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long postId, Long commentId, CommentRequestDto commentRequestDto) {
        postRepository.findById(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (!commentRequestDto.getText().isEmpty())
            comment.setText(commentRequestDto.getText());
        Comment queryResult = commentRepository.save(comment);
        return CommentMapper.toCommentResponseDto(queryResult);
    }

    // TODO: check if the user is the author of the post
    @Transactional
    public CommentResponseDto deleteComment(Long postId, Long commentId) {
        postRepository.findById(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(comment);
        return CommentMapper.toCommentResponseDto(comment);
    }

}
