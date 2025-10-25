package com.github.bahaaio.blogapi.post;

import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
    Post postRequestToPost(PostRequest postRequest);
}
