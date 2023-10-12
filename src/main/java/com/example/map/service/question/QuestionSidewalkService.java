package com.example.map.service.question;

import com.example.map.dto.service.QuestionSidewalkResultModel;
import com.example.map.dto.service.QuestionSidewalkServiceModel;

public interface QuestionSidewalkService {
    void add(QuestionSidewalkServiceModel questionSidewalkServiceModel, Long id);

    QuestionSidewalkResultModel getResult(Long id);
}
