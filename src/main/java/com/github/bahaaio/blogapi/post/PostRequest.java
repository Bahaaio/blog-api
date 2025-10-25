package com.github.bahaaio.blogapi.post;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostRequest {
    private String title;
    private String content;
    private String category;
    private List<String> tags;
}
