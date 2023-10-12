package com.example.map.dto.line;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Properties {
    private Long FID;
    private Long id;
    private String name;
    private String type;
    private String modified_a = LocalDateTime.now().toString();
    private String modified_b;

    public String getName() {
        return name;
    }

    public Properties setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Properties setType(String type) {
        this.type = type;
        return this;
    }

    public String getModified_b() {
        return modified_b;
    }

    public Properties setModified_b(String modified_b) {
        this.modified_b = modified_b;
        return this;
    }

    public Long getFID() {
        return FID;
    }

    public Properties setFID(Long FID) {
        this.FID = FID;
        return this;
    }
}
