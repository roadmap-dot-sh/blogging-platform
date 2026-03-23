/*
 * PostService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.bloggingplatform.service;

import com.example.bloggingplatform.dto.PostRequest;
import com.example.bloggingplatform.dto.PostResponse;
import com.example.bloggingplatform.exception.PostNotFoundException;
import com.example.bloggingplatform.mapper.PostMapper;
import com.example.bloggingplatform.model.Post;
import com.example.bloggingplatform.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PostService.java
 *
 * @author Nguyen
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private final PostMapper postMapper;

    public PostResponse createPost(PostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setCategory(postRequest.getCategory());
        post.setTags(postRequest.getTags());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        Post savedPost = postRepository.save(post);

        return postMapper.mapToResponse(savedPost);
    }

    public PostResponse getPost(String postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));

        return postMapper.mapToResponse(post);
    }

    public List<PostResponse> getAllPosts(String term) {
        List<Post> posts;

        if (term != null && !term.isEmpty()) {
            posts = postRepository.searchByTerm(term);
        } else {
            posts = postRepository.findAll();
        }

        return posts.stream()
                .map(postMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public PostResponse updatePost(String postId, PostRequest postRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));

        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setCategory(postRequest.getCategory());
        post.setTags(postRequest.getTags());
        post.setUpdatedAt(LocalDateTime.now());

        Post updatedPost = postRepository.save(post);

        return postMapper.mapToResponse(updatedPost);
    }

    public void deletePost(String postId) {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException("Post not found with id: " + postId);
        }
        postRepository.deleteById(postId);
    }
}
