package com.pr_dm.eco.post.mapper;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.post.dto.PostRequestDto;
import com.pr_dm.eco.post.dto.PostResponseDto;
import com.pr_dm.eco.post.entity.Post;

public class PostMapper {
    public static Post toPostEntity(PostRequestDto requestDto, User user) {
        return Post.builder()
                .userId(user.getUserId())
                .title(requestDto.getTitle())
                .text(requestDto.getText())
                .build();
    }
    public static PostResponseDto toPostResponseDto(Post requestDto) {
        return PostResponseDto.builder()
                .postId(requestDto.getPostId())
                .userId(requestDto.getUserId())
                .title(requestDto.getTitle())
                .text(requestDto.getText())
                .registerDate(requestDto.getRegisterDate())
                .build();
    }

}
