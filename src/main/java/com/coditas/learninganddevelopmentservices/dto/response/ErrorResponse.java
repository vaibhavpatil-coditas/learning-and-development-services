package com.coditas.learninganddevelopmentservices.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class ErrorResponse {
    private String message;
    private LocalDateTime timestamp;
    private Integer status;
}
