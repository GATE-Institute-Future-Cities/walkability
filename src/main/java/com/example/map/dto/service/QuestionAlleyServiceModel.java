package com.example.map.dto.service;

import java.util.List;

public class QuestionAlleyServiceModel {
    private String questionOne;
    private String questionTwo;
    private List<String> questionSubTwo;
    private String questionThree;
    private String questionFour;
    private String questionFive;
    private String questionSix;

    public QuestionAlleyServiceModel() {
    }

    public QuestionAlleyServiceModel(String questionOne, String questionTwo, List<String> questionSubTwo, String questionThree, String questionFour, String questionFive, String questionSix) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionSubTwo = questionSubTwo;
        this.questionThree = questionThree;
        this.questionFour = questionFour;
        this.questionFive = questionFive;
        this.questionSix = questionSix;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public QuestionAlleyServiceModel setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public List<String> getQuestionSubTwo() {
        return questionSubTwo;
    }

    public QuestionAlleyServiceModel setQuestionSubTwo(List<String> questionSubTwo) {
        this.questionSubTwo = questionSubTwo;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionAlleyServiceModel setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionAlleyServiceModel setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionAlleyServiceModel setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionAlleyServiceModel setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }

    public String getQuestionSix() {
        return questionSix;
    }

    public QuestionAlleyServiceModel setQuestionSix(String questionSix) {
        this.questionSix = questionSix;
        return this;
    }
}
