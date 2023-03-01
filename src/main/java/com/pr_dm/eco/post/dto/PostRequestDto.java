package com.pr_dm.eco.post.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDto {
    private String userId;

    private String title;

    private String text;
}
