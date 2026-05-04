package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.LectureRequestDto;
import com.coditas.learninganddevelopmentservices.dto.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Lecture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    Lecture toLecture(LectureRequestDto lectureRequestDto);
    List<Lecture> toLectureList(List<LectureRequestDto> lectureRequestDtoList);
    LectureResponseDto toLectureResponseDto(Lecture lecture);
    List<LectureResponseDto> toLectureResponseDtoList(List<Lecture> lectures);
}
