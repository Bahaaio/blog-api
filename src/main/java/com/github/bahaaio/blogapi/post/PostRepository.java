package com.github.bahaaio.blogapi.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostByTitleContainingOrContentContainingOrCategoryContaining(
            String title,
            String content,
            String category
    );
}
