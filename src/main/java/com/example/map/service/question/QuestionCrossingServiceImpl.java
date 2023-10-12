package com.example.map.service.question;

import com.example.map.dto.service.QuestionCrossingResultModel;
import com.example.map.dto.service.QuestionCrossingServiceModel;
import com.example.map.entity.QuestionCrossing;
import com.example.map.repository.MapRepository;
import com.example.map.repository.QuestionCrossingRepository;
import org.jdom2.output.LineSeparator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class QuestionCrossingServiceImpl implements QuestionCrossingService {

    private final QuestionCrossingRepository questionCrossingRepository;

    private final MapRepository mapRepository;

    public QuestionCrossingServiceImpl(QuestionCrossingRepository questionCrossingRepository, MapRepository mapRepository) {
        this.questionCrossingRepository = questionCrossingRepository;
        this.mapRepository = mapRepository;
    }

    @Override
    public void add(QuestionCrossingServiceModel questionCrossingServiceModel, Long id) {
        QuestionCrossing entity = new QuestionCrossing();
        entity.setQuestionOne(questionCrossingServiceModel.getQuestionOne().split("-")[0]);
        entity.setQuestionTwo(questionCrossingServiceModel.getQuestionTwo().split("-")[0]);
        entity.setQuestionThree(questionCrossingServiceModel.getQuestionThree().split("-")[0] + " " + String.join(", ", questionCrossingServiceModel.getQuestionSubThree()));
        entity.setQuestionFour(questionCrossingServiceModel.getQuestionFour().split("-")[0] + " " + String.join(", ", questionCrossingServiceModel.getQuestionSubFour()));
        entity.setQuestionFive(questionCrossingServiceModel.getQuestionFive().split("-")[0]);
        entity.setFeature(this.mapRepository.findById(id).orElse(null));
        entity.setDate(LocalDateTime.now());

        this.questionCrossingRepository.save(entity);
    }

    @Override
    public QuestionCrossingResultModel getResult(Long id) {
        Long A1 = this.questionCrossingRepository.countByQuestionOneContainsAndFeature_Id("A1", id);
        Long A2 = this.questionCrossingRepository.countByQuestionOneContainsAndFeature_Id("A2", id);
        Long A3 = this.questionCrossingRepository.countByQuestionOneContainsAndFeature_Id("A3", id);

        Long B1 = this.questionCrossingRepository.countByQuestionTwoContainsAndFeature_Id("B1", id);
        Long B2 = this.questionCrossingRepository.countByQuestionTwoContainsAndFeature_Id("B2", id);
        Long B3 = this.questionCrossingRepository.countByQuestionTwoContainsAndFeature_Id("B3", id);
        Long B4 = this.questionCrossingRepository.countByQuestionTwoContainsAndFeature_Id("B4", id);
        Long B5 = this.questionCrossingRepository.countByQuestionTwoContainsAndFeature_Id("B5", id);
        Long B6 = this.questionCrossingRepository.countByQuestionTwoContainsAndFeature_Id("B6", id);

        Long C1 = this.questionCrossingRepository.countByQuestionThreeContainsAndFeature_Id("C11", id);
        Long C2 = this.questionCrossingRepository.countByQuestionThreeContainsAndFeature_Id("C12", id);
        Long C3 = this.questionCrossingRepository.countByQuestionThreeContainsAndFeature_Id("C13", id);
        Long C4 = this.questionCrossingRepository.countByQuestionThreeContainsAndFeature_Id("C2", id);

        Long D1 = this.questionCrossingRepository.countByQuestionFourContainsAndFeature_Id("D11", id);
        Long D2 = this.questionCrossingRepository.countByQuestionFourContainsAndFeature_Id("D12", id);
        Long D3 = this.questionCrossingRepository.countByQuestionFourContainsAndFeature_Id("D13", id);
        String D4 = this.processingQuestion(this.questionCrossingRepository.getByQuestionFourContainsAndFeature_Id("D1", id));
        Long D5 = this.questionCrossingRepository.countByQuestionFourContainsAndFeature_Id("D2", id);

        Long I1 = this.questionCrossingRepository.countByQuestionFiveContainsAndFeature_Id("I1", id);
        Long I2 = this.questionCrossingRepository.countByQuestionFiveContainsAndFeature_Id("I2", id);
        Long I3 = this.questionCrossingRepository.countByQuestionFiveContainsAndFeature_Id("I3", id);

        QuestionCrossingResultModel model = new QuestionCrossingResultModel();
        model.setA1(A1).setA2(A2).setA3(A3)
                .setB1(B1).setB2(B2).setB3(B3).setB4(B4).setB5(B5).setB6(B6)
                .setC1(C1).setC2(C2).setC3(C3).setC4(C4)
                .setD1(D1).setD2(D2).setD3(D3).setD4(D4).setD5(D5)
                .setI1(I1).setI2(I2).setI3(I3);

        return model;

    }

    private String processingQuestion(List<QuestionCrossing> questionFour) {
        var result = questionFour.stream().map(a -> {
            if (a.getQuestionFour().split("(D[0-9]+,?\\s+)+").length > 1) {
                return a.getQuestionFour().split("(D[0-9]+,?\\s+)+")[1];
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
