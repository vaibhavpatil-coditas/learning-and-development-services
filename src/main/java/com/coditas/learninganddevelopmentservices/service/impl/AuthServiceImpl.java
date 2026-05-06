package com.coditas.learninganddevelopmentservices.service.impl;

import com.coditas.learninganddevelopmentservices.dto.request.LoginRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.JwtResponse;
import com.coditas.learninganddevelopmentservices.security.jwt.JwtUtils;
import com.coditas.learninganddevelopmentservices.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public JwtResponse login(LoginRequestDto loginRequestDto) {
        JwtResponse jwtResponse = null;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        if(authentication.isAuthenticated()){
            UserDetails user = (UserDetails) authentication.getPrincipal();
            if(user!=null) jwtResponse = JwtResponse.builder().token(jwtUtils.generateToken(user)).build();
        }
        return jwtResponse;
    }
}
