package com.example.map.service.criteria;

import com.example.map.dto.service.QuestionAlleyCriteriaResultService;
import com.example.map.dto.service.QuestionCrossingCriteriaResultService;
import com.example.map.dto.service.QuestionCrossingServiceModel;

public interface CrossingCriteriaService{
    void add(QuestionCrossingServiceModel model, Long id);

    QuestionCrossingCriteriaResultService getResult(Long id);
}
