package com.coditas.learninganddevelopmentservices.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LectureProgressResponseDto {
    private Long id;
    private EmployeeResponseDto employee;
    private LectureResponseDto lecture;
    private CourseResponseDto course;
}
