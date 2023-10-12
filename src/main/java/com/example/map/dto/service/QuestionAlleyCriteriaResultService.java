package com.example.map.dto.service;

public class QuestionAlleyCriteriaResultService {
    private Double accessibilityWalkability;
    private Double security;
    private Double comfortAppeal;

    public QuestionAlleyCriteriaResultService() {
    }

    public QuestionAlleyCriteriaResultService(Double accessibilityWalkability, Double security, Double comfortAppeal) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
        this.comfortAppeal = comfortAppeal;
    }

    public Double getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public QuestionAlleyCriteriaResultService setAccessibilityWalkability(Double accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Double getSecurity() {
        return security;
    }

    public QuestionAlleyCriteriaResultService setSecurity(Double security) {
        this.security = security;
        return this;
    }

    public Double getComfortAppeal() {
        return comfortAppeal;
    }

    public QuestionAlleyCriteriaResultService setComfortAppeal(Double comfortAppeal) {
        this.comfortAppeal = comfortAppeal;
        return this;
    }
}
