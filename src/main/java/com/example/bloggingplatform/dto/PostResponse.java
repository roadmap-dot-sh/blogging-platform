/*
 * PostResponse.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.bloggingplatform.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * PostResponse.java
 *
 * @author Nguyen
 */
@Data
@Builder
public class PostResponse {
    private String id;
    private String title;
    private String content;
    private String category;
    private List<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
