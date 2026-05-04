package com.coditas.learninganddevelopmentservices.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QuestionResponseDto {
    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
}
