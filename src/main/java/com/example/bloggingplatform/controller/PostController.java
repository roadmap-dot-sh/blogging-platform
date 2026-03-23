/*
 * PostController.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.bloggingplatform.controller;

import com.example.bloggingplatform.dto.PostRequest;
import com.example.bloggingplatform.dto.PostResponse;
import com.example.bloggingplatform.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PostController.java
 *
 * @author Nguyen
 */
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@Valid @RequestBody PostRequest postRequest) {
        PostResponse createdPost = postService.createPost(postRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable String id) {
        PostResponse post = postService.getPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(@RequestParam(required = false) String term) {
        List<PostResponse> posts = postService.getAllPosts(term);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable String id,
            @Valid @RequestBody PostRequest postRequest
    ) {
        PostResponse updatePost = postService.updatePost(id, postRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatePost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
