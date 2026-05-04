package com.coditas.learninganddevelopmentservices.dto;

import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class EnrollmentRequestDto {

    @NotNull
    private LocalDateTime deadline;

    @Valid
    @NotNull
    private Employee employee;

    @Valid
    private Course course;
}
