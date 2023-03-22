package com.pr_dm.eco.comment.mapper;

import com.pr_dm.eco.comment.dto.CommentRequestDto;
import com.pr_dm.eco.comment.dto.CommentResponseDto;
import com.pr_dm.eco.comment.entity.Comment;

public class CommentMapper {
    public static Comment toCommentEntity(CommentRequestDto requestDto) {
        return Comment.builder()
                .text(requestDto.getText())
                .build();
    }
    public static CommentResponseDto toCommentResponseDto(Comment requestDto) {
        return CommentResponseDto.builder()
                .postId(requestDto.getCommentId())
                .userId(requestDto.getUser().getUserId())
                .text(requestDto.getText())
                .registerDate(requestDto.getRegisterDate())
                .build();
    }
}
