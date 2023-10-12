package com.example.map.repository;

import com.example.map.entity.QuestionCrossing;
import com.example.map.entity.QuestionSidewalk;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface QuestionSidewalkRepository extends JpaRepository<QuestionSidewalk, Long>{

    Long countByQuestionOneContainsAndFeature_Id(String str, Long id);

    List<QuestionSidewalk> getByQuestionOneContainsAndFeature_Id(String str, Long id);

    Long countByQuestionTwoContainsAndFeature_Id(String str, Long id);

    List<QuestionSidewalk> getByQuestionTwoContainsAndFeature_Id(String str, Long id);

    Long countByQuestionThreeContainsAndFeature_Id(String str, Long id);

    List<QuestionSidewalk> getByQuestionThreeContainsAndFeature_Id(String str, Long id);

    Long countByQuestionFourContainsAndFeature_Id(String str, Long id);

    Long countByQuestionFiveContainsAndFeature_Id(String str, Long id);

    Long countByQuestionSixContainsAndFeature_Id(String str, Long id);

    Long countByQuestionSevenContainsAndFeature_Id(String str, Long id);

    Long countByQuestionEightContainsAndFeature_Id(String str, Long id);

    Long countByQuestionNineContainsAndFeature_Id(String str, Long id);

    Long countByQuestionTenContainsAndFeature_Id(String str, Long id);

    Long countByQuestionElevenContainsAndFeature_Id(String str, Long id);

    Long countByQuestionTwelveContainsAndFeature_Id(String str, Long id);

    Long countByFeature_Id(Long id);
}
