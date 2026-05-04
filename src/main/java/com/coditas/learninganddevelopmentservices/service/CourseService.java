package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.CourseRequestDto;
import com.coditas.learninganddevelopmentservices.dto.CourseResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAll();

    CourseResponseDto create(@Valid CourseRequestDto courseRequestDto);
}
