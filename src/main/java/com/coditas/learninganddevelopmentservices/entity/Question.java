package com.coditas.learninganddevelopmentservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter @Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

//    @ManyToOne
//    @JoinColumn(name = "quiz_id")
//    private Quiz quiz;
}
