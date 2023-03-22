package com.pr_dm.eco.post.dto;



import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDto {
    private Long userId;
    private String title;
    private String text;
    private Long categoryId;

    /*public Post toEntity(Category category) {

    }
*/

}
