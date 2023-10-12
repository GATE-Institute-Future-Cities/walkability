package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name="specifics")
public class Specific extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private SpecificType specific;

    public Specific() {
    }

    public Specific(SpecificType specific) {
        this.specific = specific;
    }

    @Enumerated(EnumType.STRING)
    public SpecificType getSpecific() {
        return specific;
    }

    public Specific setSpecific(SpecificType specific) {
        this.specific = specific;
        return this;
    }
}
