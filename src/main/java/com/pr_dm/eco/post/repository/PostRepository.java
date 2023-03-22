package com.pr_dm.eco.post.repository;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.category.entity.Category;
import com.pr_dm.eco.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {
    //Optional<Post> findByPostId(Long postId);
    List<User> findByUserId(User user);

    List<Post> findByCategory(Category category);

    @Query("SELECT p FROM Post p ORDER BY p.postId DESC")
    List<Post> findAllDesc();


}
