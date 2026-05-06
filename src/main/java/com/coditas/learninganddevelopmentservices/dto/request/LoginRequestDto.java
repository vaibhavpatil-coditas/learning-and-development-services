package com.coditas.learninganddevelopmentservices.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
