package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeStatusAndTotalEnrollmentsGreaterThan(EmployeeStatus employeeStatus, Long totalEnrollments);

    List<Employee> findByEmployeeStatusAndTotalEnrollments(EmployeeStatus employeeStatus, long l);

    Optional<Employee> findByUser(UserDetails user);
}
