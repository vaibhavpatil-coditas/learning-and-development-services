package com.coditas.learninganddevelopmentservices.dto.request;

import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EmployeeRequestDto {
    @NotBlank
    private String name;

    @NotNull
    private EmployeeStatus employeeStatus;

    @PositiveOrZero
    private int totalEnrollments;

    @NotNull
    private UserRequestDto user;
}
