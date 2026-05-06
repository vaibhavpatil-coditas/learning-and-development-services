package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.response.LectureProgressResponseDto;
import com.coditas.learninganddevelopmentservices.entity.LectureProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LectureProgressMapper {

    LectureProgressResponseDto toLectureProgressResponseDto(LectureProgress lectureProgress);
}
