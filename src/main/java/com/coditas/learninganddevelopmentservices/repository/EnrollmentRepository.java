package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByEmployeeAndCourse(Employee employee, Course course);
}
