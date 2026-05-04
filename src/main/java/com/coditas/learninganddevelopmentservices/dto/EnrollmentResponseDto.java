package com.coditas.learninganddevelopmentservices.dto;

import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class EnrollmentResponseDto {
    private Long id;

    private LocalDateTime deadline;

    private Employee employee;

    private Course course;
}
