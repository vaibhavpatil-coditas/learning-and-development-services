package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.request.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EmployeeResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAll();

    EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto);

    List<EmployeeResponseDto> getBenchedAndEnrolled();

    List<EmployeeResponseDto> getBenchedAndNotEnrolled();
}
