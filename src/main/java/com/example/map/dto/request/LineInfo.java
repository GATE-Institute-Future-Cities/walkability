package com.example.map.dto.request;

public class LineInfo {
    private String name;
    private String type;
    private Object coordinates;
    private String lineType;
    private Double length;

    public String getName() {
        return name;
    }

    public LineInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public LineInfo setType(String type) {
        this.type = type;
        return this;
    }

    public Object getCoordinates() {
        return coordinates;
    }

    public LineInfo setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public String getLineType() {
        return lineType;
    }

    public LineInfo setLineType(String lineType) {
        this.lineType = lineType;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public LineInfo setLength(Double length) {
        this.length = length;
        return this;
    }
}
