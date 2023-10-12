package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="questions_alleys")
public class QuestionAlley extends BaseEntity{
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    private String questionFour;
    private String questionFive;
    private String questionSix;
    private Feature feature;
    private LocalDateTime date;

    public QuestionAlley() {
    }

    public QuestionAlley(String questionOne, String questionTwo, String questionThree, String questionFour, String questionFive, String questionSix) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
        this.questionFour = questionFour;
        this.questionFive = questionFive;
        this.questionSix = questionSix;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public QuestionAlley setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
        return this;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public QuestionAlley setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
        return this;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public QuestionAlley setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
        return this;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public QuestionAlley setQuestionFour(String questionFour) {
        this.questionFour = questionFour;
        return this;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public QuestionAlley setQuestionFive(String questionFive) {
        this.questionFive = questionFive;
        return this;
    }

    public String getQuestionSix() {
        return questionSix;
    }

    public QuestionAlley setQuestionSix(String questionSix) {
        this.questionSix = questionSix;
        return this;
    }

    @ManyToOne
    public Feature getFeature() {
        return this.feature;
    }

    public QuestionAlley setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public QuestionAlley setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
