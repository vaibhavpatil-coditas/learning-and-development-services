package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.mapper.CourseMapper;
import com.coditas.learninganddevelopmentservices.repository.CourseRepository;
import com.coditas.learninganddevelopmentservices.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponseDto getAll() {
        List<Course> courses = courseRepository.findAll();

        return null;
    }
}
