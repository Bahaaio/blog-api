package com.github.bahaaio.blogapi.bootstrap;

import com.github.bahaaio.blogapi.post.Post;
import com.github.bahaaio.blogapi.post.PostRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final PostRepository postRepository;

    @Override
    public void run(String... args) {

        if (postRepository.count() != 0) {
            return;
        }

        postRepository.save(Post.builder()
                .title("10 Reasons Why Coffee Makes You a Better Developer ☕")
                .content("Let's face it, code and coffee go together like semicolons and syntax errors.")
                .category("Developer Life")
                .tags(Set.of("coffee", "productivity", "coding", "life-hacks"))
                .build()
        );

        postRepository.save(Post.builder()
                .title("Building APIs That Don't Suck: A Developer's Guide 🚀")
                .content("Your users deserve better than 500 errors and cryptic responses.")
                .category("Web Development")
                .tags(Set.of("api", "backend", "best-practices", "spring-boot"))
                .build()
        );

        postRepository.save(Post.builder()
                .title("Why Debugging at 3 AM Always Finds the Bug 🐛")
                .content("There's something magical about late-night debugging sessions.")
                .category("Developer Life")
                .tags(Set.of("debugging", "midnight-coding", "developer-humor"))
                .build()
        );
    }
}
