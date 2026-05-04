package com.coditas.learninganddevelopmentservices.mapper;

import com.coditas.learninganddevelopmentservices.dto.request.QuestionRequestDto;
import com.coditas.learninganddevelopmentservices.dto.response.QuestionResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toQuestion(QuestionRequestDto questionRequestDto);
    QuestionResponseDto toQuestionResponseDto(Question question);
    List<Question> toQuestionList(List<QuestionRequestDto> questionRequestDtoList);
    List<QuestionResponseDto> toQuestionResponseDtoList(List<Question> questions);
}
