package com.example.map.service.question;

import com.example.map.dto.service.QuestionAlleyResultModel;
import com.example.map.dto.service.QuestionAlleyServiceModel;
import com.example.map.dto.service.QuestionCrossingResultModel;

public interface QuestionAllayService {
    void add(QuestionAlleyServiceModel questionAlleyServiceModel, Long id);

    QuestionAlleyResultModel getResult(Long id);
}
