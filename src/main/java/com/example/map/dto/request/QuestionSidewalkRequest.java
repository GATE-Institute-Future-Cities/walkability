package com.example.map.dto.request;

import java.util.ArrayList;
import java.util.List;

public class QuestionSidewalkRequest {
    private String questionOne;
    private List<String> questionSubOne = new ArrayList<>();
    private String questionTwo;
    private List<String> questionSubTwo = new ArrayList<>();
    private String questionThree;
    private List<String> questionSubThree = new ArrayList<>();
    private String questionFour;
    private String questionFive;
    private String questionSix;
    private String questionSeven;
    private String questionEight;
    private String questionNine;
    private String questionTen;
    private String questionEleven;
    private String questionTwelve;

    public QuestionSidewalkRequest() {
    }

    public QuestionSidewalkRequest(String questionOne, List<String> questionSubOne, String questionTwo, List<String> questionSubTwo, String questionThree, List<String> questionSubThree, String questionFour, String questionFive, String questionSix, String questionSeven, String questionEight, String questionNine, String questionTen, String questionEleven, String questionTwelve) {
        this.questionOne = questionOne;
        this.questionSubOne = questionSubOne;
        this.questionTwo = questionTwo;
        this.questionSubTwo = questionSubTwo;
        this.questionThree = questionThree;
        this.questionSubThree = questionSubThree;
        this.questionFour = questionFour;
        this.questionFive = questionFive;
        this.questionSix = questionSix;
        this.questionSeven = questionSeven;
        this.questionEight = questionEight;
        this.questionNine = questionNine;
        this.questionTen = questionTen;
        this.questionEleven = questionEleven;
        this.questionTwelve = questionTwelve;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public QuestionSidewalkRequest setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public List<String> getQuestionSubOne() {
        return questionSubOne;
    }

    public QuestionSidewalkRequest setQuestionSubOne(List<String> questionSubOne) {
        this.questionSubOne = questionSubOne;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionSidewalkRequest setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public List<String> getQuestionSubTwo() {
        return questionSubTwo;
    }

    public QuestionSidewalkRequest setQuestionSubTwo(List<String> questionSubTwo) {
        this.questionSubTwo = questionSubTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionSidewalkRequest setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public List<String> getQuestionSubThree() {
        return questionSubThree;
    }

    public QuestionSidewalkRequest setQuestionSubThree(List<String> questionSubThree) {
        this.questionSubThree = questionSubThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionSidewalkRequest setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionSidewalkRequest setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }

    public String getQuestionSix() {
        return questionSix;
    }

    public QuestionSidewalkRequest setQuestionSix(String questionSix) {
        this.questionSix = questionSix;
        return this;
    }

    public String getQuestionSeven() {
        return questionSeven;
    }

    public QuestionSidewalkRequest setQuestionSeven(String questionSeven) {
        this.questionSeven = questionSeven;
        return this;
    }

    public String getQuestionEight() {
        return questionEight;
    }

    public QuestionSidewalkRequest setQuestionEight(String questionEight) {
        this.questionEight = questionEight;
        return this;
    }

    public String getQuestionNine() {
        return questionNine;
    }

    public QuestionSidewalkRequest setQuestionNine(String questionNine) {
        this.questionNine = questionNine;
        return this;
    }

    public String getQuestionTen() {
        return questionTen;
    }

    public QuestionSidewalkRequest setQuestionTen(String questionTen) {
        this.questionTen = questionTen;
        return this;
    }

    public String getQuestionEleven() {
        return questionEleven;
    }

    public QuestionSidewalkRequest setQuestionEleven(String questionEleven) {
        this.questionEleven = questionEleven;
        return this;
    }

    public String getQuestionTwelve() {
        return questionTwelve;
    }

    public QuestionSidewalkRequest setQuestionTwelve(String questionTwelve) {
        this.questionTwelve = questionTwelve;
        return this;
    }
}
