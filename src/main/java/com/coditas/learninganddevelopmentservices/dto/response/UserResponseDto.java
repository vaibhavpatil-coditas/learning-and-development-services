package com.coditas.learninganddevelopmentservices.dto.response;

import com.coditas.learninganddevelopmentservices.security.roles.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {
    private String email;

    private Role role;
}
