package com.example.map.service.criteria;

import com.example.map.dto.service.QuestionAlleyCriteriaResultService;
import com.example.map.dto.service.QuestionSidewalkCriteriaResultService;
import com.example.map.dto.service.QuestionSidewalkServiceModel;

public interface SidewalkCriteriaService {
    void add(QuestionSidewalkServiceModel model, Long id);

    QuestionSidewalkCriteriaResultService getResult(Long id);
}
