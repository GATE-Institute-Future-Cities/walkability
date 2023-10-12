package com.example.map.dto.service;

public class QuestionCrossingCriteriaResultService {
    private Double accessibilityWalkability;
    private Double security;

    public QuestionCrossingCriteriaResultService() {
    }

    public QuestionCrossingCriteriaResultService(Double accessibilityWalkability, Double security) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
    }

    public Double getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public QuestionCrossingCriteriaResultService setAccessibilityWalkability(Double accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Double getSecurity() {
        return security;
    }

    public QuestionCrossingCriteriaResultService setSecurity(Double security) {
        this.security = security;
        return this;
    }
}
