package com.coditas.learninganddevelopmentservices.dto.response;

import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeResponseDto {
    private Long id;

    private String name;

    private EmployeeStatus employeeStatus;

    private int totalEnrollments;
}
