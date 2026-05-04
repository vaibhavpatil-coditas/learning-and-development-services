package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.request.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import com.coditas.learninganddevelopmentservices.mapper.EmployeeMapper;
import com.coditas.learninganddevelopmentservices.repository.EmployeeRepository;
import com.coditas.learninganddevelopmentservices.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        employeeRequestDto.setTotalEnrollments(0);
        Employee employee = employeeMapper.toEmployee(employeeRequestDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponseDto(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDto> getBenchedAndEnrolled() {
        List<Employee> employees = employeeRepository.findByEmployeeStatus(EmployeeStatus.BENCHED);
        return employeeMapper.toEmployeeResponseDtoList(employees);
    }
}
