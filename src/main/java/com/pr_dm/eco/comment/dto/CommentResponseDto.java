package com.pr_dm.eco.comment.dto;

import com.pr_dm.eco.User.entity.User;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private Long postId;

    private String text;

    private LocalDate registerDate;

    private LocalDate modifyDate;
}