package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.request.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAll(){
        List<EmployeeResponseDto> response = employeeService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> create(@Valid @RequestBody EmployeeRequestDto employeeRequestDto){
        EmployeeResponseDto response = employeeService.create(employeeRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/employees/"+response.getId())).body(response);
    }

    @GetMapping("?status=bench&is_enrolled=true")
    public ResponseEntity<List<EmployeeResponseDto>> getBenchedAndEnrolled(){
        List<EmployeeResponseDto> response = employeeService.getBenchedAndEnrolled();
        return null;
    }
}
