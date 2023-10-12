package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="questions_sidewalks")
public class QuestionSidewalk extends BaseEntity{
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    private String questionFour;
    private String questionFive;
    private String questionSix;
    private String questionSeven;
    private String questionEight;
    private String questionNine;
    private String questionTen;
    private String questionEleven;
    private String questionTwelve;
    private Feature feature;
    private LocalDateTime date;

    public QuestionSidewalk() {
    }

    public QuestionSidewalk(String questionOne, String questionTwo, String questionThree, String questionFour, String questionFive, String questionSix, String questionSeven, String questionEight, String questionNine, String questionTen, String questionEleven, String questionTwelve) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
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

    public QuestionSidewalk setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionSidewalk setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionSidewalk setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionSidewalk setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionSidewalk setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }

    public String getQuestionSix() {
        return questionSix;
    }

    public QuestionSidewalk setQuestionSix(String questionSix) {
        this.questionSix = questionSix;
        return this;
    }

    public String getQuestionSeven() {
        return questionSeven;
    }

    public QuestionSidewalk setQuestionSeven(String questionSeven) {
        this.questionSeven = questionSeven;
        return this;
    }

    public String getQuestionEight() {
        return questionEight;
    }

    public QuestionSidewalk setQuestionEight(String questionEight) {
        this.questionEight = questionEight;
        return this;
    }

    public String getQuestionNine() {
        return questionNine;
    }

    public QuestionSidewalk setQuestionNine(String questionNine) {
        this.questionNine = questionNine;
        return this;
    }

    public String getQuestionTen() {
        return questionTen;
    }

    public QuestionSidewalk setQuestionTen(String questionTen) {
        this.questionTen = questionTen;
        return this;
    }

    public String getQuestionEleven() {
        return questionEleven;
    }

    public QuestionSidewalk setQuestionEleven(String questionEleven) {
        this.questionEleven = questionEleven;
        return this;
    }

    public String getQuestionTwelve() {
        return questionTwelve;
    }

    public QuestionSidewalk setQuestionTwelve(String questionTwelve) {
        this.questionTwelve = questionTwelve;
        return this;
    }

    @ManyToOne
    public Feature getFeature() {
        return feature;
    }

    public QuestionSidewalk setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public QuestionSidewalk setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
