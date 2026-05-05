package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.request.CourseRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.mapper.CourseMapper;
import com.coditas.learninganddevelopmentservices.repository.CourseRepository;
import com.coditas.learninganddevelopmentservices.repository.EmployeeRepository;
import com.coditas.learninganddevelopmentservices.repository.EnrollmentRepository;
import com.coditas.learninganddevelopmentservices.security.jwt.JwtUtils;
import com.coditas.learninganddevelopmentservices.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseMapper courseMapper;
    private final JwtUtils jwtUtils;

    @Override
    public List<CourseResponseDto> getAll() {
        List<Course> courses = null;
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user!=null && user.getAuthorities().stream().anyMatch(role->role.getAuthority().equals("ROLE_ADMIN"))){
            courses = courseRepository.findAll();
        }else{
            Employee employee = employeeRepository.findByUser(user).orElseThrow(()->
                    new RuntimeException("Employee not found"));
            courses = courseRepository.findCoursesByEmployeeId(employee.getId());
        }
        return courseMapper.toCourseResponseDtoList(courses);
    }

    @Override
    @Transactional
    public CourseResponseDto create(CourseRequestDto courseRequestDto) {
        Course course = courseMapper.toCourse(courseRequestDto);
        course.getLectures().forEach(lecture -> lecture.setCourse(course));
        course.getQuestions().forEach(question -> question.setCourse(course));
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toCourseResponseDto(savedCourse);
    }
}
