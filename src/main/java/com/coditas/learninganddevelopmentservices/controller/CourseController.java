package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.CourseResponseDto;
import com.coditas.learninganddevelopmentservices.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<CourseResponseDto> getAll(){
        CourseResponseDto response = courseService.getAll();
        return ;
    }
}
