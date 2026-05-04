package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Employee;
import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
}
