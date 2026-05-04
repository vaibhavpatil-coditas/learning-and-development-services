package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EnrollmentResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponseDto> getAll();

    EnrollmentResponseDto create(@Valid EnrollmentRequestDto enrollmentRequestDto);
}
