package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EnrollmentResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Enrollment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    List<EnrollmentResponseDto> toEnrollmentResponseDtoList(List<Enrollment> enrollments);

    Enrollment toEnrollment(EnrollmentRequestDto enrollmentRequestDto);

    EnrollmentResponseDto toEnrollmentResponseDto(Enrollment savedEnrollment);
}
