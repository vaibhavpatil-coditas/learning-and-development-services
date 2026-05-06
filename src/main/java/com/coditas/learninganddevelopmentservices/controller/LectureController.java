package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.response.LectureProgressResponseDto;
import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{lectureId}")
    public ResponseEntity<LectureResponseDto> getById(@PathVariable Long courseId, @PathVariable Long lectureId){
        LectureResponseDto response = lectureService.getById(courseId, lectureId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{lectureId}/complete")
    public ResponseEntity<LectureProgressResponseDto> markComplete(@PathVariable Long courseId, @PathVariable Long lectureId){
        LectureProgressResponseDto response = lectureService.markAsCompleted(courseId, lectureId);
        return ResponseEntity.ok(response);
    }
}
