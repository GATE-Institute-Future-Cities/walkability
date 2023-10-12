package com.example.map.service.question;

import com.example.map.dto.service.QuestionSidewalkResultModel;
import com.example.map.dto.service.QuestionSidewalkServiceModel;
import com.example.map.entity.QuestionSidewalk;
import com.example.map.repository.MapRepository;
import com.example.map.repository.QuestionSidewalkRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class QuestionSidewalkServiceImpl implements QuestionSidewalkService {

    private final QuestionSidewalkRepository questionSidewalkRepository;

    private final MapRepository mapRepository;

    public QuestionSidewalkServiceImpl(QuestionSidewalkRepository questionSidewalkRepository, MapRepository mapRepository) {
        this.questionSidewalkRepository = questionSidewalkRepository;
        this.mapRepository = mapRepository;
    }


    @Override
    public void add(QuestionSidewalkServiceModel questionSidewalkServiceModel, Long id) {
        QuestionSidewalk entity = new QuestionSidewalk();
        entity.setQuestionOne(questionSidewalkServiceModel.getQuestionOne().split("-")[0] + " " + String.join(", ", questionSidewalkServiceModel.getQuestionSubOne()));
        entity.setQuestionTwo(questionSidewalkServiceModel.getQuestionTwo().split("-")[0] + " " + String.join(", ", questionSidewalkServiceModel.getQuestionSubTwo()));
        entity.setQuestionThree(questionSidewalkServiceModel.getQuestionThree().split("-")[0] + " " + String.join(", ", questionSidewalkServiceModel.getQuestionSubThree()));
        entity.setQuestionFour(questionSidewalkServiceModel.getQuestionFour().split("-")[0]);
        entity.setQuestionFive(questionSidewalkServiceModel.getQuestionFive().split("-")[0]);
        entity.setQuestionSix(questionSidewalkServiceModel.getQuestionSix().split("-")[0]);
        entity.setQuestionSeven(questionSidewalkServiceModel.getQuestionSeven().split("-")[0]);
        entity.setQuestionEight(questionSidewalkServiceModel.getQuestionEight().split("-")[0]);
        entity.setQuestionNine(questionSidewalkServiceModel.getQuestionNine().split("-")[0]);
        entity.setQuestionTen(questionSidewalkServiceModel.getQuestionTen().split("-")[0]);
        entity.setQuestionEleven(questionSidewalkServiceModel.getQuestionEleven().split("-")[0]);
        entity.setQuestionTwelve(questionSidewalkServiceModel.getQuestionTwelve().split("-")[0]);
        entity.setFeature(this.mapRepository.findById(id).orElse(null));
        entity.setDate(LocalDateTime.now());

        this.questionSidewalkRepository.save(entity);
    }

    @Override
    public QuestionSidewalkResultModel getResult(Long id) {
        Long A1 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A11", id);
        Long A2 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A12", id);
        Long A3 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A13", id);
        Long A4 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A14", id);
        Long A5 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A15", id);
        Long A6 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A16", id);
        String A7 = this.processingQuestionOne(this.questionSidewalkRepository.getByQuestionOneContainsAndFeature_Id("A1", id), "(A[0-9]+,?\\s+)+");
        Long A8 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A21", id);
        Long A9 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A22", id);
        Long A10 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A23", id);
        Long A11 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A24", id);
        Long A12 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A25", id);
        Long A13 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A26", id);
        String A14 = this.processingQuestionOne(this.questionSidewalkRepository.getByQuestionOneContainsAndFeature_Id("A2", id), "(A[0-9]+,?\\s+)+");
        Long A15 = this.questionSidewalkRepository.countByQuestionOneContainsAndFeature_Id("A3", id);

        Long B1 = this.questionSidewalkRepository.countByQuestionTwoContainsAndFeature_Id("B11", id);
        Long B2 = this.questionSidewalkRepository.countByQuestionTwoContainsAndFeature_Id("B12", id);
        Long B3 = this.questionSidewalkRepository.countByQuestionTwoContainsAndFeature_Id("B13", id);
        String B4 = this.processingQuestionTwo(this.questionSidewalkRepository.getByQuestionTwoContainsAndFeature_Id("B1", id), "(B[0-9]+,?\\s+)+");
        Long B5 = this.questionSidewalkRepository.countByQuestionTwoContainsAndFeature_Id("B2", id);


        Long C1 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C11", id);
        Long C2 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C12", id);
        Long C3 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C13", id);
        Long C4 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C14", id);
        String C5 = this.processingQuestionThree(this.questionSidewalkRepository.getByQuestionThreeContainsAndFeature_Id("C1", id), "(C[0-9]+,?\\s+)+");
        Long C6 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C21", id);
        Long C7 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C22", id);
        Long C8 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C23", id);
        Long C9 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C24", id);
        String C10 = this.processingQuestionThree(this.questionSidewalkRepository.getByQuestionThreeContainsAndFeature_Id("C2", id), "(C[0-9]+,?\\s+)+");
        Long C11 = this.questionSidewalkRepository.countByQuestionThreeContainsAndFeature_Id("C3", id);


        Long D1 = this.questionSidewalkRepository.countByQuestionFourContainsAndFeature_Id("D1", id);
        Long D2 = this.questionSidewalkRepository.countByQuestionFourContainsAndFeature_Id("D2", id);

        Long E1 = this.questionSidewalkRepository.countByQuestionFiveContainsAndFeature_Id("E1", id);
        Long E2 = this.questionSidewalkRepository.countByQuestionFiveContainsAndFeature_Id("E2", id);

        Long F1 = this.questionSidewalkRepository.countByQuestionSixContainsAndFeature_Id("F1", id);
        Long F2 = this.questionSidewalkRepository.countByQuestionSixContainsAndFeature_Id("F2", id);
        Long F3 = this.questionSidewalkRepository.countByQuestionSixContainsAndFeature_Id("F3", id);

        Long G1 = this.questionSidewalkRepository.countByQuestionSevenContainsAndFeature_Id("G1", id);
        Long G2 = this.questionSidewalkRepository.countByQuestionSevenContainsAndFeature_Id("G2", id);

        Long H1 = this.questionSidewalkRepository.countByQuestionEightContainsAndFeature_Id("H1", id);
        Long H2 = this.questionSidewalkRepository.countByQuestionEightContainsAndFeature_Id("H2", id);
        Long H3 = this.questionSidewalkRepository.countByQuestionEightContainsAndFeature_Id("H3", id);
        Long H4 = this.questionSidewalkRepository.countByQuestionEightContainsAndFeature_Id("H4", id);

        Long I1 = this.questionSidewalkRepository.countByQuestionNineContainsAndFeature_Id("I1", id);
        Long I2 = this.questionSidewalkRepository.countByQuestionNineContainsAndFeature_Id("I2", id);
        Long I3 = this.questionSidewalkRepository.countByQuestionNineContainsAndFeature_Id("I3", id);

        Long J1 = this.questionSidewalkRepository.countByQuestionTenContainsAndFeature_Id("J1", id);
        Long J2 = this.questionSidewalkRepository.countByQuestionTenContainsAndFeature_Id("J2", id);
        Long J3 = this.questionSidewalkRepository.countByQuestionTenContainsAndFeature_Id("J3", id);

        Long K1 = this.questionSidewalkRepository.countByQuestionElevenContainsAndFeature_Id("K1", id);
        Long K2 = this.questionSidewalkRepository.countByQuestionElevenContainsAndFeature_Id("K2", id);
        Long K3 = this.questionSidewalkRepository.countByQuestionElevenContainsAndFeature_Id("K3", id);

        Long L1 = this.questionSidewalkRepository.countByQuestionTwelveContainsAndFeature_Id("L1", id);
        Long L2 = this.questionSidewalkRepository.countByQuestionTwelveContainsAndFeature_Id("L2", id);
        Long L3 = this.questionSidewalkRepository.countByQuestionTwelveContainsAndFeature_Id("L3", id);
        Long L4 = this.questionSidewalkRepository.countByQuestionTwelveContainsAndFeature_Id("L4", id);

        QuestionSidewalkResultModel model = new QuestionSidewalkResultModel();
        model.setA1(A1).setA2(A2).setA3(A3).setA4(A4).setA5(A5).setA6(A6).setA7(A7).setA8(A8).setA9(A9).setA10(A10).setA11(A11).setA12(A12).setA13(A13).setA14(A14).setA15(A15)
                .setB1(B1).setB2(B2).setB3(B3).setB4(B4).setB5(B5)
                .setC1(C1).setC2(C2).setC3(C3).setC4(C4).setC5(C5).setC6(C6).setC7(C7).setC8(C8).setC9(C9).setC10(C10).setC11(C11)
                .setD1(D1).setD2(D2)
                .setE1(E1).setE2(E2)
                .setF1(F1).setF2(F2).setF3(F3)
                .setG1(G1).setG2(G2)
                .setH1(H1).setH2(H2).setH3(H3).setH4(H4)
                .setI1(I1).setI2(I2).setI3(I3)
                .setJ1(J1).setJ2(J2).setJ3(J3)
                .setK1(K1).setK2(K2).setK3(K3)
                .setL1(L1).setL2(L2).setL3(L3).setL4(L4);

        return model;
    }

    private String processingQuestionOne(List<QuestionSidewalk> question, String regex) {
        var result = question.stream().map(a -> {
            if (a.getQuestionOne().split(regex).length > 1) {
                return a.getQuestionOne().split(regex)[1];
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

    private String processingQuestionTwo(List<QuestionSidewalk> question, String regex) {
        var result = question.stream().map(a -> {
            if (a.getQuestionTwo().split(regex).length > 1) {
                return a.getQuestionTwo().split(regex)[1];
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

    private String processingQuestionThree(List<QuestionSidewalk> question, String regex) {
        var result = question.stream().map(a -> {
            if (a.getQuestionThree().split(regex).length > 1) {
                return a.getQuestionThree().split(regex)[1];
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
