package com.example.map.dto.service;

public class InfUser {
    private String role;
    private String question;

    public String getRole() {
        return role;
    }

    public InfUser setRole(String role) {
        this.role = role;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public InfUser setQuestion(String question) {
        this.question = question;
        return this;
    }
}
