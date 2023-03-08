package com.pr_dm.eco.comment.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequestDto {
    private String userId;

    private String text;
}