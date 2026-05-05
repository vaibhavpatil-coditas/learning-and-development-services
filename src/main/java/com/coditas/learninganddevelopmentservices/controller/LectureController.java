package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.LectureProgressResponseDto;
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
    public ResponseEntity<?> getById(@RequestParam Boolean isCompleted, @PathVariable Long courseId, @PathVariable Long lectureId){
        if(isCompleted!=null && isCompleted){
            LectureProgressResponseDto lectureProgressResponseDto = lectureService.markAsCompleted(courseId, lectureId);
        }
        LectureResponseDto response = lectureService.getById(courseId, lectureId);
        return ResponseEntity.ok(response);
    }
}
