package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EmployeeResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAll();

    EmployeeResponseDto create(@Valid EmployeeRequestDto employeeRequestDto);
}
