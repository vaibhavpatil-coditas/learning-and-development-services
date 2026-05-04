package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.request.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EnrollmentResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
uses = {EmployeeMapper.class, CourseMapper.class})
public interface EnrollmentMapper {

    List<EnrollmentResponseDto> toEnrollmentResponseDtoList(List<Enrollment> enrollments);

    @Mapping(source = "employeeId",target = "employee.id")
    @Mapping(source = "courseId",target = "course.id")
    Enrollment toEnrollment(EnrollmentRequestDto enrollmentRequestDto);

    EnrollmentResponseDto toEnrollmentResponseDto(Enrollment savedEnrollment);
}
