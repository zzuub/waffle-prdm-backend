package com.pr_dm.eco.post.entity;


import com.pr_dm.eco.category.entity.Category;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private Long userId;

    private String title;

    private String text;

    @CreationTimestamp
    private LocalDate registerDate = LocalDate.now();


    @LastModifiedDate
    private LocalDate modifyDate;

    //@ManyToOne
    //@Enumerated(EnumType.STRING)

//    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /*@OneToMany(mappedBy="post", cascade= CascadeType.ALL, orphanRemoval= true)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();*/

    @Builder
    public Post(Long userId, String title, String text, Category category){
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.category = category;
//        this.categoryId = categoryId;
    }


}
