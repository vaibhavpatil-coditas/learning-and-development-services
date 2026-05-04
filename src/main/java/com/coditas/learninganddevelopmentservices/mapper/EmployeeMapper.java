package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.request.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EmployeeResponseDto;
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
