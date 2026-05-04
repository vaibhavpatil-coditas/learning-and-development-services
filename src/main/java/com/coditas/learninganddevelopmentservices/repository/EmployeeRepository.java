package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
