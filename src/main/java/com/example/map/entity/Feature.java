package com.example.map.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "features")
public class Feature extends BaseEntity{
    private String geometry;
    private Object featureInfo;
    private Set<Picture> pictures;
    private List<CommentEntity> comments;
 
    public Feature() {
    }

    public String getGeometry() {
        return this.geometry;
    }

    public Feature setGeometry(String geometry) {
        this.geometry = geometry;
        return this;
    }

    public Object getFeatureInfo() {
        return this.featureInfo;
    }

    public Feature setFeatureInfo(Object featureInfo) {
        this.featureInfo = featureInfo;
        return this;
    }

    @OneToMany(mappedBy = "feature", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public Feature setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    @OneToMany(mappedBy = "feature", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<CommentEntity> getComments() {
        return comments;
    }

    public Feature setComments(List<CommentEntity> comments) {
        this.comments = comments;
        return this;
    }
}
