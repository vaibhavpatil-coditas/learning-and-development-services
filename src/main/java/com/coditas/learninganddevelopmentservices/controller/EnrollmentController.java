package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.EnrollmentRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EnrollmentResponseDto;
import com.coditas.learninganddevelopmentservices.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDto>> getAll(){
        List<EnrollmentResponseDto> response = enrollmentService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> create(@Valid @RequestBody EnrollmentRequestDto enrollmentRequestDto){
        EnrollmentResponseDto response = enrollmentService.create(enrollmentRequestDto);
        return ResponseEntity.created(URI.create("api/v1/enrollments/"+response.getId())).body(response);
    }

    @GetMapping("/date")
    public LocalDateTime getDate(){
        return LocalDateTime.now();
    }
}
