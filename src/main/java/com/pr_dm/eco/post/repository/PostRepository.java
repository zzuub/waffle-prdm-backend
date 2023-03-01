package com.pr_dm.eco.post.repository;

import com.pr_dm.eco.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
