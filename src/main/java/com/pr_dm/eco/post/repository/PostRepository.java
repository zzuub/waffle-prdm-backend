package com.pr_dm.eco.post.repository;

import com.pr_dm.eco.post.entity.Post;
import com.pr_dm.eco.post.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByPostId(Long postId);
    List<Post> findByCategoryId(PostCategory categoryId);
}
