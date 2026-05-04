package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
