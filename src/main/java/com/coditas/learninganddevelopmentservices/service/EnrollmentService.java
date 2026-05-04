package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.request.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EnrollmentResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponseDto> getAll();

    EnrollmentResponseDto create(@Valid EnrollmentRequestDto enrollmentRequestDto);
}
