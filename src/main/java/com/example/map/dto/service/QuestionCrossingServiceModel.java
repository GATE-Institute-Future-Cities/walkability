package com.example.map.dto.service;

import java.util.List;

public class QuestionCrossingServiceModel {
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    private List<String> questionSubThree;
    private String questionFour;
    private List<String> questionSubFour;
    private String questionFive;

    public QuestionCrossingServiceModel() {
    }

    public QuestionCrossingServiceModel(String questionOne, String questionTwo, String questionThree, List<String> questionSubThree, String questionFour, List<String> questionSubFour, String questionFive) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
        this.questionSubThree = questionSubThree;
        this.questionFour = questionFour;
        this.questionSubFour = questionSubFour;
        this.questionFive = questionFive;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public QuestionCrossingServiceModel setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionCrossingServiceModel setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionCrossingServiceModel setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public List<String> getQuestionSubThree() {
        return questionSubThree;
    }

    public QuestionCrossingServiceModel setQuestionSubThree(List<String> questionSubThree) {
        this.questionSubThree = questionSubThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionCrossingServiceModel setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public List<String> getQuestionSubFour() {
        return questionSubFour;
    }

    public QuestionCrossingServiceModel setQuestionSubFour(List<String> questionSubFour) {
        this.questionSubFour = questionSubFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionCrossingServiceModel setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }
}
