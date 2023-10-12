package com.example.map.service.question;

import com.example.map.dto.service.QuestionAlleyResultModel;
import com.example.map.dto.service.QuestionAlleyServiceModel;
import com.example.map.entity.QuestionAlley;
import com.example.map.entity.QuestionCrossing;
import com.example.map.repository.MapRepository;
import com.example.map.repository.QuestionAlleyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class QuestionAllayServiceImpl implements QuestionAllayService {

    private final QuestionAlleyRepository questionAlleyRepository;

    private final MapRepository mapRepository;


    public QuestionAllayServiceImpl(QuestionAlleyRepository questionAlleyRepository, MapRepository mapRepository) {
        this.questionAlleyRepository = questionAlleyRepository;
        this.mapRepository = mapRepository;
    }

    @Override
    public void add(QuestionAlleyServiceModel questionAlleyServiceModel, Long id) {
        QuestionAlley entity = new QuestionAlley();
        entity.setQuestionOne(questionAlleyServiceModel.getQuestionOne().split("-")[0]);
        entity.setQuestionTwo(questionAlleyServiceModel.getQuestionTwo().split("-")[0] +
                " " + String.join(", ", questionAlleyServiceModel.getQuestionSubTwo()));
        entity.setQuestionThree(questionAlleyServiceModel.getQuestionThree().split("-")[0]);
        entity.setQuestionFour(questionAlleyServiceModel.getQuestionFour().split("-")[0]);
        entity.setQuestionFive(questionAlleyServiceModel.getQuestionFive().split("-")[0]);
        entity.setQuestionSix(questionAlleyServiceModel.getQuestionSix().split("-")[0]);
        entity.setFeature(this.mapRepository.findById(id).orElse(null));
        entity.setDate(LocalDateTime.now());

        this.questionAlleyRepository.save(entity);
    }

    @Override
    public QuestionAlleyResultModel getResult(Long id) {
        Long A1 = this.questionAlleyRepository.countByQuestionOneContainsAndFeature_Id("A1", id);
        Long A2 = this.questionAlleyRepository.countByQuestionOneContainsAndFeature_Id("A2", id);
        Long A3 = this.questionAlleyRepository.countByQuestionOneContainsAndFeature_Id("A3", id);
        Long A4 = this.questionAlleyRepository.countByQuestionOneContainsAndFeature_Id("A4", id);
        Long A5 = this.questionAlleyRepository.countByQuestionOneContainsAndFeature_Id("A5", id);

        Long B1 = this.questionAlleyRepository.countByQuestionTwoContainsAndFeature_Id("B1", id);
        Long B2 = this.questionAlleyRepository.countByQuestionTwoContainsAndFeature_Id("B21", id);
        Long B3 = this.questionAlleyRepository.countByQuestionTwoContainsAndFeature_Id("B22", id);
        Long B4 = this.questionAlleyRepository.countByQuestionTwoContainsAndFeature_Id("B23", id);
        String B5 = this.processingQuestion(this.questionAlleyRepository.getByQuestionTwoContainsAndFeature_Id("B2", id));

        Long C1 = this.questionAlleyRepository.countByQuestionThreeContainsAndFeature_Id("C1", id);
        Long C2 = this.questionAlleyRepository.countByQuestionThreeContainsAndFeature_Id("C2", id);
        Long C3 = this.questionAlleyRepository.countByQuestionThreeContainsAndFeature_Id("C3", id);

        Long D1 = this.questionAlleyRepository.countByQuestionFourContainsAndFeature_Id("D1", id);
        Long D2 = this.questionAlleyRepository.countByQuestionFourContainsAndFeature_Id("D2", id);
        Long D3 = this.questionAlleyRepository.countByQuestionFourContainsAndFeature_Id("D3", id);
        Long D4 = this.questionAlleyRepository.countByQuestionFourContainsAndFeature_Id("D4", id);

        Long E1 = this.questionAlleyRepository.countByQuestionFiveContainsAndFeature_Id("E1", id);
        Long E2 = this.questionAlleyRepository.countByQuestionFiveContainsAndFeature_Id("E2", id);
        Long E3 = this.questionAlleyRepository.countByQuestionFiveContainsAndFeature_Id("E3", id);

        Long F1 = this.questionAlleyRepository.countByQuestionSixContainsAndFeature_Id("F1", id);
        Long F2 = this.questionAlleyRepository.countByQuestionSixContainsAndFeature_Id("F2", id);
        Long F3 = this.questionAlleyRepository.countByQuestionSixContainsAndFeature_Id("F3", id);

        QuestionAlleyResultModel model = new QuestionAlleyResultModel();
        model.setA1(A1).setA2(A2).setA3(A3).setA4(A4).setA5(A5)
                .setB1(B1).setB2(B2).setB3(B3).setB4(B4).setB5(B5)
                .setC1(C1).setC2(C2).setC3(C3)
                .setD1(D1).setD2(D2).setD3(D3).setD4(D4)
                .setE1(E1).setE2(E2).setE3(E3)
                .setF1(F1).setF2(F2).setF3(F3);

        return model;
    }

    private String processingQuestion(List<QuestionAlley> questionTwo) {
        var result = questionTwo.stream().map(a -> {
            if (a.getQuestionTwo().split("(B[0-9]+,?\\s+)+").length > 1) {
                return a.getQuestionTwo().split("(B[0-9]+,?\\s+)+")[1];
            }
            return "";

        }).toList();
        var map = new LinkedHashMap<String, Integer>();

        for (String text : result) {
            var textList = Arrays.stream(text.split(",\\s+")).toList();
            for (String str : textList) {
                var currantStr = str.toLowerCase();
                if (!currantStr.equals("")) {
                    if (map.containsKey(currantStr)) {
                        map.put(currantStr, map.get(currantStr) + 1);
                    } else {
                        map.put(currantStr, 1);
                    }
                }
            }
        }
        var finalResult = new StringBuilder();
        for (var entry : map.entrySet()) {
            finalResult.append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue())
                    .append("; ")
                    .append(System.lineSeparator());
        }
        return finalResult.toString().trim();
    }
}
