package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
}
