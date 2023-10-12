package com.example.map.dto.response;

public class QuestionCrossingCriteriaResultResponse {
    private Integer accessibilityWalkability;
    private Integer security;

    public QuestionCrossingCriteriaResultResponse() {
    }

    public QuestionCrossingCriteriaResultResponse(Integer accessibilityWalkability, Integer security) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
    }

    public Integer getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public QuestionCrossingCriteriaResultResponse setAccessibilityWalkability(Integer accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Integer getSecurity() {
        return security;
    }

    public QuestionCrossingCriteriaResultResponse setSecurity(Integer security) {
        this.security = security;
        return this;
    }
}
