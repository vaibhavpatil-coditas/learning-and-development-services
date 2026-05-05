package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.dto.response.LectureResponseDto;
import com.coditas.learninganddevelopmentservices.entity.Course;
import com.coditas.learninganddevelopmentservices.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<LectureResponseDto> findByCourse(Course course);
}
