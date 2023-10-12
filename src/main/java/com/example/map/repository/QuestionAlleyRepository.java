package com.example.map.repository;

import com.example.map.entity.QuestionAlley;
import com.example.map.entity.QuestionCrossing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAlleyRepository extends JpaRepository<QuestionAlley, Long> {

    Long countByQuestionOneContainsAndFeature_Id(String str, Long id);

    Long countByQuestionTwoContainsAndFeature_Id(String str, Long id);

    Long countByQuestionThreeContainsAndFeature_Id(String str, Long id);

    Long countByQuestionFourContainsAndFeature_Id(String str, Long id);

    Long countByQuestionFiveContainsAndFeature_Id(String str, Long id);

    Long countByQuestionSixContainsAndFeature_Id(String str, Long id);

    Long countByFeature_Id(Long id);

    List<QuestionAlley> getByQuestionTwoContainsAndFeature_Id(String d1, Long id);
}
