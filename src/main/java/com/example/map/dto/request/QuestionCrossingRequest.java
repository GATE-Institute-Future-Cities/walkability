package com.example.map.dto.request;

import java.util.ArrayList;
import java.util.List;

public class QuestionCrossingRequest {
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    private List<String> questionSubThree = new ArrayList<>();
    private String questionFour;
    private List<String> questionSubFour = new ArrayList<>();
    private String questionFive;

    public QuestionCrossingRequest() {
    }

    public QuestionCrossingRequest(String questionOne, String questionTwo, String questionThree, List<String> questionSubThree, String questionFour, List<String> questionSubFour, String questionFive) {
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

    public QuestionCrossingRequest setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionCrossingRequest setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionCrossingRequest setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public List<String> getQuestionSubThree() {
        return questionSubThree;
    }

    public QuestionCrossingRequest setQuestionSubThree(List<String> questionSubThree) {
        this.questionSubThree = questionSubThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionCrossingRequest setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public List<String> getQuestionSubFour() {
        return questionSubFour;
    }

    public QuestionCrossingRequest setQuestionSubFour(List<String> questionSubFour) {
        this.questionSubFour = questionSubFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionCrossingRequest setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }
}
