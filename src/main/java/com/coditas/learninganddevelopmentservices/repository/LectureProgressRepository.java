package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.entity.Lecture;
import com.coditas.learninganddevelopmentservices.entity.LectureProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureProgressRepository extends JpaRepository<LectureProgress, Long> {
    long countByEmployeeAndCourse(Employee employee, Course course);
}
