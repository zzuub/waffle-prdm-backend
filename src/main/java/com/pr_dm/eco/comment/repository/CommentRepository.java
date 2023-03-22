package com.pr_dm.eco.comment.repository;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.comment.entity.Comment;
import com.pr_dm.eco.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByPost(Post post, Pageable pageable);

    //List<Comment> findByPostId(Long postId);

    //Optional<Comment> findByUserAndPost(User userId, Post post);
}
