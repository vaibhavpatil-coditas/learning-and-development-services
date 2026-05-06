package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.request.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EnrollmentResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.entity.Enrollment;
import com.coditas.learninganddevelopmentservices.mapper.EnrollmentMapper;
import com.coditas.learninganddevelopmentservices.repository.CourseRepository;
import com.coditas.learninganddevelopmentservices.repository.EmployeeRepository;
import com.coditas.learninganddevelopmentservices.repository.EnrollmentRepository;
import com.coditas.learninganddevelopmentservices.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final CourseRepository courseRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<EnrollmentResponseDto> getAll() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollmentMapper.toEnrollmentResponseDtoList(enrollments);
    }

    @Override
    @Transactional
    public EnrollmentResponseDto create(EnrollmentRequestDto enrollmentRequestDto) {
        Enrollment enrollment = enrollmentMapper.toEnrollment(enrollmentRequestDto);
        enrollment.setCompletedLectureCount(0);

        Course course = courseRepository.findById(enrollmentRequestDto.getCourseId()).orElseThrow(()->
                new RuntimeException("Course Id not found"));
        Employee employee = employeeRepository.findById(enrollmentRequestDto.getEmployeeId()).orElseThrow(()->
                new RuntimeException("Employee Id not found"));

        enrollment.setCourse(course);
        enrollment.setEmployee(employee);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        employee.setTotalEnrollments(employee.getTotalEnrollments()+1);
        employeeRepository.save(employee);
        return enrollmentMapper.toEnrollmentResponseDto(savedEnrollment);
    }
}
