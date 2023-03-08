package com.pr_dm.eco.post.entity;

import com.pr_dm.eco.comment.entity.Comment;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class  Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String userId;

    private String title;

    private String text;

    @CreationTimestamp
    private LocalDateTime registerDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy="post", cascade= CascadeType.ALL, orphanRemoval= true)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    //조회수는 나중에...
    @Enumerated(EnumType.STRING)
    private PostCategory categoryId;


    @Builder
    public Post(String userId, String title, String text){
        this.userId = userId;
        this.title = title;
        this.text = text;
    }


}
