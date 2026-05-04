package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.mapper.EmployeeMapper;
import com.coditas.learninganddevelopmentservices.repository.EmployeeRepository;
import com.coditas.learninganddevelopmentservices.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponseDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toEmployeeResponseDtoList(employees);
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        employeeRequestDto.setTotalEnrollments(0);
        Employee employee = employeeMapper.toEmployee(employeeRequestDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponseDto(savedEmployee);
    }
}
