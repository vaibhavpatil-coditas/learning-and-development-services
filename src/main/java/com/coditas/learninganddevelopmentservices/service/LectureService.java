package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.response.LectureProgressResponseDto;
import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;

import java.util.List;

public interface LectureService {
    List<LectureResponseDto> getAll(Long courseId);

    LectureResponseDto getById(Long courseId, Long lectureId);

    LectureProgressResponseDto markAsCompleted(Long courseId, Long lectureId);
}
