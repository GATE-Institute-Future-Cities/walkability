package com.example.map.dto.response;

public class QuestionSidewalkCriteriaResultResponse {
    private Integer accessibilityWalkability;
    private Integer security;
    private Integer comfortAppeal;

    public QuestionSidewalkCriteriaResultResponse() {
    }

    public QuestionSidewalkCriteriaResultResponse(Integer accessibilityWalkability, Integer security, Integer comfortAppeal) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
        this.comfortAppeal = comfortAppeal;
    }

    public Integer getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public QuestionSidewalkCriteriaResultResponse setAccessibilityWalkability(Integer accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Integer getSecurity() {
        return security;
    }

    public QuestionSidewalkCriteriaResultResponse setSecurity(Integer security) {
        this.security = security;
        return this;
    }

    public Integer getComfortAppeal() {
        return comfortAppeal;
    }

    public QuestionSidewalkCriteriaResultResponse setComfortAppeal(Integer comfortAppeal) {
        this.comfortAppeal = comfortAppeal;
        return this;
    }
}
