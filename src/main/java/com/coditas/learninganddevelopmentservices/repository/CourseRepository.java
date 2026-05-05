package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.id IN " +
            "(SELECT e.course.id FROM Enrollment e WHERE e.employee.id = :employeeId)")
    List<Course> findCoursesByEmployeeId(@Param("employeeId") Long employeeId);
}
