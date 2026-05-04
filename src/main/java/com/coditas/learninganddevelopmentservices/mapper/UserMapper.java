package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.request.UserRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.UserResponseDto;
import com.coditas.learninganddevelopmentservices.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestDto userRequestDto);
    UserResponseDto toUserResponseDto(User user);
}
