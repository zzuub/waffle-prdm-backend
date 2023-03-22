package com.pr_dm.eco.comment.dto;

import com.pr_dm.eco.User.entity.User;
import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private Long postId;

    private Long userId;

    private String text;

    private LocalDateTime registerDate;

    private LocalDateTime modifyDate;
}