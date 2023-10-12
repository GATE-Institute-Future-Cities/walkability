package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="questions_crossings")
public class QuestionCrossing extends BaseEntity{
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    private String questionFour;
    private String questionFive;
    private Feature feature;
    private LocalDateTime date;

    public QuestionCrossing() {
    }

    public QuestionCrossing(String questionOne, String questionTwo, String questionThree, String questionFour, String questionFive) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
        this.questionFour = questionFour;
        this.questionFive = questionFive;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public QuestionCrossing setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionCrossing setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionCrossing setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionCrossing setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionCrossing setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }

    @ManyToOne
    public Feature getFeature() {
        return feature;
    }

    public QuestionCrossing setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public QuestionCrossing setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
