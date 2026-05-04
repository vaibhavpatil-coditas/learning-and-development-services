package com.coditas.learninganddevelopmentservices.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class CourseRequestDto {
    @NotBlank
    private String title;

    @NotEmpty
    private List<QuestionRequestDto> questions;

    @Valid
    @NotEmpty
    private List<LectureRequestDto> lectures;
}
