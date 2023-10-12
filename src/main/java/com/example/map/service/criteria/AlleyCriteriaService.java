package com.example.map.service.criteria;

import com.example.map.dto.service.QuestionAlleyCriteriaResultService;
import com.example.map.dto.service.QuestionAlleyServiceModel;

public interface AlleyCriteriaService {
    void add(QuestionAlleyServiceModel model, Long id);

    QuestionAlleyCriteriaResultService getResult(Long id);
}
