package com.github.bahaaio.blogapi.post;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostRequest {
    @NotBlank
    @Size(min = 4, max = 200)
    private String title;

    @NotBlank
    @Size(max = 10_000)
    private String content;

    @NotBlank
    @Size(max = 50)
    private String category;

    @NotNull
    @Size(max = 10)
    private Set<String> tags;
}
