package com.pr_dm.eco.comment.entity;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.post.entity.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

//    private Long userId;
    @ManyToOne //(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String text;

    @CreationTimestamp
    private LocalDate registerDate = LocalDate.now();

    @LastModifiedDate
    private LocalDate modifyDate;

    @ManyToOne //(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    private Post post;


    @Builder
    public Comment(User user, String text, Post post){
        this.user = user;
        this.text = text;
        this.post = post;
    }

}
