package com.pr_dm.eco.comment.dto;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private Long postId;

    private String userId;

    private String text;

    private LocalDateTime registerDate;

    private LocalDateTime modifyDate;
}