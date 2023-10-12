package com.example.map.service.question;

import com.example.map.dto.service.QuestionCrossingResultModel;
import com.example.map.dto.service.QuestionCrossingServiceModel;

public interface QuestionCrossingService {
    void add(QuestionCrossingServiceModel questionCrossingServiceModel, Long id);

    QuestionCrossingResultModel getResult(Long id);
}
