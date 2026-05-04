//package com.coditas.learninganddevelopmentservices.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "quizzes")
//@Getter @Setter
//@NoArgsConstructor
//public class Quiz {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//}
