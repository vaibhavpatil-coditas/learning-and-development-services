package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.request.CourseRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.CourseResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAll();

    CourseResponseDto create(@Valid CourseRequestDto courseRequestDto);

    CourseResponseDto getById(Long courseId);
}
