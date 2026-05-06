package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.request.CourseRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.exception.CourseNotFoundException;
import com.coditas.learninganddevelopmentservices.exception.EmployeeNotFoundException;
import com.coditas.learninganddevelopmentservices.exception.ExceptionMessages;
import com.coditas.learninganddevelopmentservices.mapper.CourseMapper;
import com.coditas.learninganddevelopmentservices.repository.CourseRepository;
import com.coditas.learninganddevelopmentservices.repository.EmployeeRepository;
import com.coditas.learninganddevelopmentservices.repository.EnrollmentRepository;
import com.coditas.learninganddevelopmentservices.security.jwt.JwtUtils;
import com.coditas.learninganddevelopmentservices.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponseDto> getAll() {
        List<Course> courses = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated()) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            if (user != null && user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
                courses = courseRepository.findAll();
            } else {
                Employee employee = employeeRepository.findByUser(user).orElseThrow(() ->
                        new EmployeeNotFoundException(ExceptionMessages.EMPLOYEE_NOT_FOUND));
                courses = courseRepository.findCoursesByEmployeeId(employee.getId());
            }
        }
        return courseMapper.toCourseResponseDtoList(courses);
    }

    @Override
    @Transactional
    public CourseResponseDto create(CourseRequestDto courseRequestDto) {
        Course course = courseMapper.toCourse(courseRequestDto);
        log.info("{}", course.getLectures().size());
        course.setNumberOfLectures((long) courseRequestDto.getLectures().size());
        course.getLectures().forEach(lecture -> lecture.setCourse(course));
        course.getQuestions().forEach(question -> question.setCourse(course));
        Course savedCourse = courseRepository.save(course);
        log.info("{}", savedCourse.getLectures().size());
        return courseMapper.toCourseResponseDto(savedCourse);
    }

    @Override
    public CourseResponseDto getById(Long courseId) {
        Course course = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated()) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            assert user != null;
            boolean isAdmin = user.getAuthorities().stream().anyMatch(role -> {
                String authority = role.getAuthority();
                assert authority != null;
                return authority.equals("ROLE_ADMIN");
            });
            if (isAdmin) {
                course = courseRepository.findById(courseId).orElseThrow(() ->
                        new CourseNotFoundException(ExceptionMessages.COURSE_NOT_FOUND));
            } else {
                Employee employee = employeeRepository.findByUser(user).orElseThrow(() ->
                        new EmployeeNotFoundException(ExceptionMessages.EMPLOYEE_NOT_FOUND));
                course = courseRepository.findById(courseId).orElseThrow(() ->
                        new CourseNotFoundException(ExceptionMessages.COURSE_NOT_FOUND));
                if (!enrollmentRepository.existsByEmployeeAndCourse(employee, course)) course = null;
            }
        }
        return courseMapper.toCourseResponseDto(course);
    }
}
