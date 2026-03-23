/*
 * PostRepository.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.bloggingplatform.repository;

import com.example.bloggingplatform.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PostRepository.java
 *
 * @author Nguyen
 */
@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    @Query("""
                SELECT p FROM Post p
                WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :term, '%'))
                OR LOWER(p.content) LIKE LOWER(CONCAT('%', :term, '%'))
                OR LOWER(p.category) LIKE LOWER(CONCAT('%', :term, '%'))
            """)
    List<Post> searchByTerm(@Param("term") String term);
}
