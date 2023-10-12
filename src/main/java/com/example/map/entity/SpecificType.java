package com.example.map.entity;

public enum SpecificType {
    ONE("with a baby carriage"),
    TWO("with a child"),
    THREE("with a wheelchair"),
    FOUR("hearing impaired"),
    FIVE("visually impaired"),
    SIX("have no");

    public final String label;

    SpecificType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

