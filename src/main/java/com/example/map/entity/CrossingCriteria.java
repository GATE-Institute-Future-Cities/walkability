package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crossings_criteries")
public class CrossingCriteria extends BaseEntity {
    private Double accessibilityWalkability;
    private Double security;
    private Feature feature;

    public CrossingCriteria() {
    }

    public CrossingCriteria(Double accessibilityWalkability, Double security, Feature feature) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
        this.feature = feature;
    }

    public Double getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public CrossingCriteria setAccessibilityWalkability(Double accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Double getSecurity() {
        return security;
    }

    public CrossingCriteria setSecurity(Double security) {
        this.security = security;
        return this;
    }

    @ManyToOne
    public Feature getFeature() {
        return feature;
    }

    public CrossingCriteria setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }
}
