package com.example.map.dto.response;

public class QuestionAlleyCriteriaResultResponse {
    private Integer accessibilityWalkability;
    private Integer security;
    private Integer comfortAppeal;

    public QuestionAlleyCriteriaResultResponse() {
    }

    public QuestionAlleyCriteriaResultResponse(Integer accessibilityWalkability, Integer security, Integer comfortAppeal) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
        this.comfortAppeal = comfortAppeal;
    }

    public Integer getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public QuestionAlleyCriteriaResultResponse setAccessibilityWalkability(Integer accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Integer getSecurity() {
        return security;
    }

    public QuestionAlleyCriteriaResultResponse setSecurity(Integer security) {
        this.security = security;
        return this;
    }

    public Integer getComfortAppeal() {
        return comfortAppeal;
    }

    public QuestionAlleyCriteriaResultResponse setComfortAppeal(Integer comfortAppeal) {
        this.comfortAppeal = comfortAppeal;
        return this;
    }
}
