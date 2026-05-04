package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
uses = UserMapper.class)
public interface EmployeeMapper {
    Employee toEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto toEmployeeResponseDto(Employee employee);
    List<EmployeeResponseDto> toEmployeeResponseDtoList(List<Employee> employee);
}
