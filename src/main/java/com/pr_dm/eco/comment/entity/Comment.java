package com.pr_dm.eco.comment.entity;

import com.pr_dm.eco.post.entity.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String userId;

    private String text;

    @CreationTimestamp
    private LocalDateTime registerDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    private Post post;
}
