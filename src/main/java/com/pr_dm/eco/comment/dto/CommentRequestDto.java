package com.pr_dm.eco.comment.dto;

import com.pr_dm.eco.User.entity.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequestDto {
    private String text;
}