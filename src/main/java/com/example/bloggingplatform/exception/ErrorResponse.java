/*
 * ErrorResponse.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.bloggingplatform.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ErrorResponse.java
 *
 * @author Nguyen
 */
@Data
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
