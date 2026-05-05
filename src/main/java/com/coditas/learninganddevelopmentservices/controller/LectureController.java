package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/courses/{courseId}/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping
    public ResponseEntity<List<LectureResponseDto>> getAll(@PathVariable Long courseId){
        List<LectureResponseDto> response = lectureService.getAll(courseId);
        return ResponseEntity.ok(response);
    }
}
