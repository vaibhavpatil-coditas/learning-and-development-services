package com.coditas.learninganddevelopmentservices.dto;

import com.coditas.learninganddevelopmentservices.dto.response.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.dto.response.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.entity.Lecture;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LectureProgressResponseDto {
    private Long id;
    private EmployeeResponseDto employee;
    private LectureResponseDto lecture;
    private CourseResponseDto course;
    private boolean isCompleted;
}
