package com.example.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import org.springframework.stereotype.Repository;
import com.example.map.entity.QuestionCrossing;

@Repository
public interface QuestionCrossingRepository extends JpaRepository<QuestionCrossing, Long> {

    Long countByQuestionOneContainsAndFeature_Id(String str, Long id);

    Long countByQuestionTwoContainsAndFeature_Id(String str, Long id);

    Long countByQuestionThreeContainsAndFeature_Id(String str, Long id);

    Long countByQuestionFourContainsAndFeature_Id(String str, Long id);

    List<QuestionCrossing>getByQuestionFourContainsAndFeature_Id(String str, Long id);

    Long countByQuestionFiveContainsAndFeature_Id(String str, Long id);

    Long countByFeature_Id(Long id);

}