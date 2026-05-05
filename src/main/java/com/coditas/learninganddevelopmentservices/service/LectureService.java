package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;

import java.util.List;

public interface LectureService {
    List<LectureResponseDto> getAll(Long courseId);
}
