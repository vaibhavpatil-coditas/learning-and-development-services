package com.coditas.learninganddevelopmentservices.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecture_progress")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "is_completed")
    private boolean isCompleted;
}
