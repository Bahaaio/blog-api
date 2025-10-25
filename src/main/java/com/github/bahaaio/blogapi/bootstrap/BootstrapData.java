package com.github.bahaaio.blogapi.bootstrap;

import com.github.bahaaio.blogapi.post.Post;
import com.github.bahaaio.blogapi.post.PostRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final PostRepository postRepository;

    @Override
    public void run(String... args) {
        postRepository.save(Post.builder()
                .title("Blog post")
                .content("example content")
                .category("Tech")
                .tags(List.of("Tech", "Coding"))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build()
        );
    }
}
