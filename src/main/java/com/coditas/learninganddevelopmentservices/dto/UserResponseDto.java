package com.coditas.learninganddevelopmentservices.dto;

import com.coditas.learninganddevelopmentservices.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {
    private String email;

    private Role role;
}
