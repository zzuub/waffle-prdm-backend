package com.pr_dm.eco.User.dto;

import com.pr_dm.eco.User.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserDto implements Serializable {
    private final String name;
    private final String nickname;
    private final String email;

    public UserDto(User user){
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }
}
