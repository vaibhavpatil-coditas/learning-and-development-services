package com.coditas.learninganddevelopmentservices.repository;

import com.coditas.learninganddevelopmentservices.entity.LectureProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureProgressRepository extends JpaRepository<LectureProgress, Long> {
}
