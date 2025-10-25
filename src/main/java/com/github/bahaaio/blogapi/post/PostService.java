package com.github.bahaaio.blogapi.post;

import com.github.bahaaio.blogapi.exception.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    List<Post> findAll() {
        return postRepository.findAll();
    }

    List<Post> findByTerm(String term) {
        return postRepository.findPostByTitleContainingOrContentContainingOrCategoryContaining(
                term, term, term
        );
    }

    Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    Post createPost(PostRequest request) {
        Post post = postMapper.postRequestToPost(request);
        return postRepository.save(post);
    }

    Post updatePost(Long id, PostRequest request) {
        Post existing = postRepository.findById(id).orElseThrow(NotFoundException::new);

        existing.setTitle(request.getTitle());
        existing.setContent(request.getContent());
        existing.setCategory(request.getCategory());
        existing.setTags(request.getTags());

        return postRepository.save(existing);
    }

    void deleteById(Long id) {
        postRepository.findById(id).orElseThrow(NotFoundException::new);
        postRepository.deleteById(id);
    }
}
