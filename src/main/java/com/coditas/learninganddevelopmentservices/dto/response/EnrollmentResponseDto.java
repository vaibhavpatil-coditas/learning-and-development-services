package com.coditas.learninganddevelopmentservices.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class EnrollmentResponseDto {
    private Long id;

    private LocalDateTime deadline;

    private EmployeeResponseDto employee;

    private CourseResponseDto course;
}
