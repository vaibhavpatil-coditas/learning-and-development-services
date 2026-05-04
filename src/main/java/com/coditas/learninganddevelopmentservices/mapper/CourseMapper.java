package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.request.CourseRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
uses = {QuestionMapper.class, LectureMapper.class})
public interface CourseMapper {

    List<CourseResponseDto> toCourseResponseDtoList(List<Course> courses);

    Course toCourse(CourseRequestDto courseRequestDto);

    CourseResponseDto toCourseResponseDto(Course course);
}
