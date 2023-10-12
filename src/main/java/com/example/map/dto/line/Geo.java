package com.example.map.dto.line;

import org.locationtech.jts.geom.Geometry;

public class Geo {
    private String type="Feature";
    private Long id;
    private GeometryDto geometry = new GeometryDto();
    private Properties properties = new Properties();

    public GeometryDto getGeometry() {
        return geometry;
    }

    public Geo setGeometry(GeometryDto geometry) {
        this.geometry = geometry;
        return this;
    }

    public Properties getProperties() {
        return properties;
    }

    public Geo setProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Geo setId(Long id) {
        this.id = id;
        return this;
    }
}
