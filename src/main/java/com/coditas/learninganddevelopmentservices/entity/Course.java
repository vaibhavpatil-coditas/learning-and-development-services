package com.coditas.learninganddevelopmentservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private List<Question> questions;

    @OneToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private List<Lecture> lectures;
}
