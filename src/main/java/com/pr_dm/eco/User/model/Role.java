package com.pr_dm.eco.User.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    //어드민은 데모 끝나고 추가?
    GUEST("ROLE_GUEST", "게스트"),
    USER("ROLE_USER", "유저");


    private final String key;
    private final String title;
}
