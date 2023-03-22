package com.pr_dm.eco.post.dto;


import com.pr_dm.eco.post.entity.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PostResponseDto {
    private Long postId;
    private Long userId;
    private String title;
    private String text;
    private Long categoryId;
    private LocalDateTime registerDate;
    private LocalDateTime modifyDate;

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.userId = post.getUserId();
        this.title = post.getTitle();
        this.text = post.getText();
        this.categoryId = post.getCategory().getCategoryId();
        this.registerDate = post.getRegisterDate();
        this.modifyDate = post.getModifyDate();
    }
}