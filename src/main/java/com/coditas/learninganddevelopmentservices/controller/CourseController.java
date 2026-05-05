package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.request.CourseRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.security.roles.Role;
import com.coditas.learninganddevelopmentservices.service.CourseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAll(){
        List<CourseResponseDto> response = courseService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CourseResponseDto> create(@Valid @RequestBody CourseRequestDto courseRequestDto){
        CourseResponseDto response = courseService.create(courseRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/courses/"+response.getId())).body(response);
    }
}
