package com.example.map.dto.service;

public class QuestionSidewalkCriteriaResultService {
    private Double accessibilityWalkability;
    private Double security;
    private Double comfortAppeal;

    public QuestionSidewalkCriteriaResultService() {
    }

    public QuestionSidewalkCriteriaResultService(Double accessibilityWalkability, Double security, Double comfortAppeal) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
        this.comfortAppeal = comfortAppeal;
    }

    public Double getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public QuestionSidewalkCriteriaResultService setAccessibilityWalkability(Double accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Double getSecurity() {
        return security;
    }

    public QuestionSidewalkCriteriaResultService setSecurity(Double security) {
        this.security = security;
        return this;
    }

    public Double getComfortAppeal() {
        return comfortAppeal;
    }

    public QuestionSidewalkCriteriaResultService setComfortAppeal(Double comfortAppeal) {
        this.comfortAppeal = comfortAppeal;
        return this;
    }
}
