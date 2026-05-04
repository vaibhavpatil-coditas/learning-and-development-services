package com.coditas.learninganddevelopmentservices.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class EnrollmentRequestDto {

    @NotNull
    private LocalDateTime deadline;

    @NotNull
    @Positive
    private Long employeeId;

    @NotNull
    @Positive
    private Long courseId;
}
