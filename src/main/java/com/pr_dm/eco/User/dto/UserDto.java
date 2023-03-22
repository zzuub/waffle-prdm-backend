package com.pr_dm.eco.User.dto;

import com.pr_dm.eco.User.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserDto {
    private Long userId;
    private String name;
    private String nickname;
    private String email;

    public UserDto(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }

    public User getUserId() {
        return User.builder().userId(userId).build();
    }
}
