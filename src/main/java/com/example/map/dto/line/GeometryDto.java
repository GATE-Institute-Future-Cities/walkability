package com.example.map.dto.line;

import java.util.ArrayList;

public class GeometryDto {
    private String type="LineString";
    private ArrayList<Object> coordinates= new ArrayList<>();

    public ArrayList<Object> getCoordinates() {
        return coordinates;
    }

    public GeometryDto setCoordinates(ArrayList<Object> coordinates) {
        this.coordinates = coordinates;
        return this;
    }
}
