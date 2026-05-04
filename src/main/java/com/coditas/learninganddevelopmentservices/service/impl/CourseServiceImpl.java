package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.CourseRequestDto;
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
    public List<CourseResponseDto> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toCourseResponseDtoList(courses);
    }

    @Override
    public CourseResponseDto create(CourseRequestDto courseRequestDto) {
        Course course = courseMapper.toCourse(courseRequestDto);
        course.getLectures().forEach(lecture -> lecture.setCourse(course));
        course.getQuestions().forEach(question -> question.setCourse(course));
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toCourseResponseDto(savedCourse);
    }
}
