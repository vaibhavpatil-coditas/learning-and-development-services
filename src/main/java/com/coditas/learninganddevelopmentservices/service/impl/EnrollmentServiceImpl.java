package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EnrollmentResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Enrollment;
import com.coditas.learninganddevelopmentservices.mapper.EnrollmentMapper;
import com.coditas.learninganddevelopmentservices.repository.EnrollmentRepository;
import com.coditas.learninganddevelopmentservices.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentResponseDto> getAll() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollmentMapper.toEnrollmentResponseDtoList(enrollments);
    }

    @Override
    public EnrollmentResponseDto create(EnrollmentRequestDto enrollmentRequestDto) {
        Enrollment enrollment = enrollmentMapper.toEnrollment(enrollmentRequestDto);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toEnrollmentResponseDto(savedEnrollment);
    }
}
