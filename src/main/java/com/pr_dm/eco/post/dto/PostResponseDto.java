package com.pr_dm.eco.post.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PostResponseDto {
    private Long postId;

    private String userId;

    private String title;

    private String text;

    private LocalDateTime registerDate;

    private LocalDateTime modifyDate;
}