package com.coditas.learninganddevelopmentservices.service;

import com.coditas.learninganddevelopmentservices.dto.LoginRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.JwtResponse;

public interface AuthService {
    JwtResponse login(LoginRequestDto loginRequestDto);
}
