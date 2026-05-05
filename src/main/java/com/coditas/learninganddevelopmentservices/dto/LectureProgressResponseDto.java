package com.coditas.learninganddevelopmentservices.dto;

import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.entity.Lecture;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LectureProgressResponseDto {
    private Long id;
    private Employee employee;
    private Lecture lecture;
    private Course course;
    private boolean isCompleted;
}
