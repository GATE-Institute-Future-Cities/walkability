package com.example.map.dto.binding;

public class Route {
    private String coord1;
    private String coord2;

    public String getCoord1() {
        return coord1;
    }

    public Route setCoord1(String coord1) {
        this.coord1 = coord1;
        return this;
    }

    public String getCoord2() {
        return coord2;
    }

    public Route setCoord2(String coord2) {
        this.coord2 = coord2;
        return this;
    }
}
