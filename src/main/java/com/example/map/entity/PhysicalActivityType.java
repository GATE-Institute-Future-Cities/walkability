package com.example.map.entity;

public enum PhysicalActivityType {
    ONE("3 or more times a week"),
    TWO("1-2 times a week"),
    THREE("1 every two weeks"),
    FOUR("less often");

    public final String label;

    PhysicalActivityType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
