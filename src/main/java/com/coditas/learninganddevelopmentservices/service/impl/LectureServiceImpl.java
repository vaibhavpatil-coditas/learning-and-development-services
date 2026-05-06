package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.response.LectureProgressResponseDto;
import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.entity.*;
import com.coditas.learninganddevelopmentservices.exception.CourseNotFoundException;
import com.coditas.learninganddevelopmentservices.exception.EmployeeNotFoundException;
import com.coditas.learninganddevelopmentservices.exception.ExceptionMessages;
import com.coditas.learninganddevelopmentservices.exception.LectureNotFound;
import com.coditas.learninganddevelopmentservices.mapper.LectureMapper;
import com.coditas.learninganddevelopmentservices.mapper.LectureProgressMapper;
import com.coditas.learninganddevelopmentservices.repository.*;
import com.coditas.learninganddevelopmentservices.service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final EmployeeRepository employeeRepository;
    private final LectureMapper lectureMapper;
    private final LectureProgressRepository lectureProgressRepository;
    private final LectureProgressMapper lectureProgressMapper;
    private final CertificateRepository certificateRepository;

    private boolean isAdminOrEnrolledEmployee(Course course) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated()) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            assert user != null;
            boolean isAdmin = user.getAuthorities().stream().anyMatch(role -> {
                String authority = role.getAuthority();
                assert authority != null;
                return authority.equals("ROLE_ADMIN");
            });
            if (!isAdmin){
                Employee employee = employeeRepository.findByUser(user).orElseThrow(() ->
                        new EmployeeNotFoundException(ExceptionMessages.EMPLOYEE_NOT_FOUND));
                return enrollmentRepository.existsByEmployeeAndCourse(employee, course);
            }
        }
        return true;
    }

    @Override
    public List<LectureResponseDto> getAll(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new CourseNotFoundException(ExceptionMessages.COURSE_NOT_FOUND));
        List<Lecture> lectures = lectureRepository.findByCourse(course);
        List<LectureResponseDto> lectureResponseDtoList = lectureMapper.toLectureResponseDtoList(lectures);
        if(!isAdminOrEnrolledEmployee(course))
            lectureResponseDtoList = null;
        return lectureResponseDtoList;
    }

    @Override
    public LectureResponseDto getById(Long courseId, Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() ->
                new LectureNotFound(ExceptionMessages.LECTURE_NOT_FOUND));
        return lectureMapper.toLectureResponseDto(lecture);
    }

    @Override
    @Transactional
    public LectureProgressResponseDto markAsCompleted(Long courseId, Long lectureId) {
        LectureProgress savedLectureProgress = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated()){
            UserDetails user = (UserDetails) authentication.getPrincipal();

            Employee employee = employeeRepository.findByUser(user).orElseThrow(() ->
                    new EmployeeNotFoundException(ExceptionMessages.EMPLOYEE_NOT_FOUND));

            Course course = courseRepository.findById(courseId).orElseThrow(()->
                    new CourseNotFoundException(ExceptionMessages.COURSE_NOT_FOUND));

            Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() ->
                    new LectureNotFound(ExceptionMessages.LECTURE_NOT_FOUND));

            LectureProgress lectureProgress = LectureProgress.builder()
                    .employee(employee)
                    .lecture(lecture)
                    .course(course)
                    .build();
            savedLectureProgress = lectureProgressRepository.save(lectureProgress);
            if(checkCourseCompleted(employee, course)){
                Certificate certificate = Certificate.builder()
                        .course(course)
                        .employee(employee)
                        .issuedDate(LocalDateTime.now())
                        .build();
                certificateRepository.save(certificate);
            }
        }
        return lectureProgressMapper.toLectureProgressResponseDto(savedLectureProgress);
    }

    private boolean checkCourseCompleted(Employee employee, Course course) {
        long numberOfLectures = course.getNumberOfLectures();
        long completedLectures = lectureProgressRepository.countByEmployeeAndCourse(employee, course);
        log.info("{}",completedLectures);
        return numberOfLectures==completedLectures;
    }
}
