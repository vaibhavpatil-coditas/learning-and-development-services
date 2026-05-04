package com.coditas.learninganddevelopmentservices.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LectureRequestDto {
    @NotBlank
    private String youtubeLink;
}
