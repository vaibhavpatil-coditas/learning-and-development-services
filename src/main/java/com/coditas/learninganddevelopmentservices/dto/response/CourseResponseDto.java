package com.coditas.learninganddevelopmentservices.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CourseResponseDto {
    private Long id;
    private String title;
    private List<LectureResponseDto> lectures;
    private Long numberOfLectures;
}
