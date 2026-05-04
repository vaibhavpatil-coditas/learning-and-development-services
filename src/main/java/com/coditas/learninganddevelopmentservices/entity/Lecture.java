package com.coditas.learninganddevelopmentservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lectures")
@Getter
@Setter
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtubeLink;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
