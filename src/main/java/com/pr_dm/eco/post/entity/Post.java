package com.pr_dm.eco.post.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String userId;

    private String title;

    private String text;

    @CreationTimestamp
    private LocalDateTime registerDate = LocalDateTime.now();
    private LocalDateTime modifyDate;

    //조회수는 나중에...


}
