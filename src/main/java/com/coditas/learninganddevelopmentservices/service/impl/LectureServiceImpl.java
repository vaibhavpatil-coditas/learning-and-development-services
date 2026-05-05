package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.repository.CourseRepository;
import com.coditas.learninganddevelopmentservices.repository.LectureRepository;
import com.coditas.learninganddevelopmentservices.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<LectureResponseDto> getAll(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new RuntimeException("Course not found"));
        return lectureRepository.findByCourse(course);
    }
}
