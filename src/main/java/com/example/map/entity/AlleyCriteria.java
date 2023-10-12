package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alleys_criteries")
public class AlleyCriteria extends BaseEntity {
    private Double accessibilityWalkability;
    private Double security;
    private Double comfortAppeal;
    private Feature feature;

    public AlleyCriteria() {
    }

    public AlleyCriteria(Double accessibilityWalkability, Double security, Double comfortAppeal, Feature feature) {
        this.accessibilityWalkability = accessibilityWalkability;
        this.security = security;
        this.comfortAppeal = comfortAppeal;
        this.feature = feature;
    }

    public Double getAccessibilityWalkability() {
        return accessibilityWalkability;
    }

    public AlleyCriteria setAccessibilityWalkability(Double accessibilityWalkability) {
        this.accessibilityWalkability = accessibilityWalkability;
        return this;
    }

    public Double getSecurity() {
        return security;
    }

    public AlleyCriteria setSecurity(Double security) {
        this.security = security;
        return this;
    }

    public Double getComfortAppeal() {
        return comfortAppeal;
    }

    public AlleyCriteria setComfortAppeal(Double comfortAppeal) {
        this.comfortAppeal = comfortAppeal;
        return this;
    }

    @ManyToOne
    public Feature getFeature() {
        return feature;
    }

    public AlleyCriteria setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }
}
