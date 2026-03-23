/*
 * PostMapper.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.bloggingplatform.mapper;

import com.example.bloggingplatform.dto.PostResponse;
import com.example.bloggingplatform.model.Post;
import org.springframework.stereotype.Component;

/**
 * PostMapper.java
 *
 * @author Nguyen
 */
@Component
public class PostMapper {
    public PostResponse mapToResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .tags(post.getTags())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
