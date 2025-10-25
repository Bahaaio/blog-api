package com.github.bahaaio.blogapi.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) Optional<String> term) {
        return term.map(s -> ResponseEntity.ok(postService.findByTerm(s)))
                .orElseGet(() -> ResponseEntity.ok(postService.findAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<Post> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    ResponseEntity<Post> createPost(@RequestBody PostRequest request) {
        Post saved = postService.createPost(request);
        return ResponseEntity.created(URI.create("/posts/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    ResponseEntity<Post> updatePost(@RequestBody PostRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(postService.updatePost(id, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
