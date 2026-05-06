package com.coditas.learninganddevelopmentservices.controller;

import com.coditas.learninganddevelopmentservices.dto.request.EmployeeRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.EmployeeResponseDto;
import com.coditas.learninganddevelopmentservices.enums.EmployeeStatus;
import com.coditas.learninganddevelopmentservices.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<List<EmployeeResponseDto>> getAll(@RequestParam(required = false, name = "status") EmployeeStatus employeeStatus, @RequestParam(required = false, name = "enrolled") Boolean isEnrolled){
        List<EmployeeResponseDto> response = null;
        if(employeeStatus == EmployeeStatus.BENCHED){
            if(isEnrolled==null || isEnrolled){
                response = employeeService.getBenchedAndEnrolled();
            }else{
                response = employeeService.getBenchedAndNotEnrolled();
            }
        }else{
            response = employeeService.getAll();
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> create(@Valid @RequestBody EmployeeRequestDto employeeRequestDto){
        EmployeeResponseDto response = employeeService.create(employeeRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/employees/"+response.getId())).body(response);
    }
}
