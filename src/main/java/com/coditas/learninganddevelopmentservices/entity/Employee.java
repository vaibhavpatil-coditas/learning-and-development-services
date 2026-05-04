package com.coditas.learninganddevelopmentservices.entity;

import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter @Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    private int totalEnrollments;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
