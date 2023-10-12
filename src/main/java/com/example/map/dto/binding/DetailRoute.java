package com.example.map.dto.binding;

import com.example.map.entity.Information;
import com.example.map.entity.Picture;
import org.json.simple.JSONObject;

import java.util.Set;

public class DetailRoute {
    private JSONObject jsonObject;
    private Set<Picture> pictures;
    private Information information;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public DetailRoute setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public DetailRoute setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Information getInformation() {
        return information;
    }

    public DetailRoute setInformation(Information information) {
        this.information = information;
        return this;
    }
}
