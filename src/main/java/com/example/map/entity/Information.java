package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="informations")
public class Information extends BaseEntity{
    private String lamp;
    private String bucket;
    private String tree;
    private String station;
    private String bench;
    private String sign;
    private String billboard;
    private String peg;
    private String shaft;
    private Feature feature;

    public Information() {
    }

    public Information(String lamp, String bucket, String tree, String station, String bench, String sign, String billboard, String peg, String shaft, Feature feature) {
        this.lamp = lamp;
        this.bucket = bucket;
        this.tree = tree;
        this.station = station;
        this.bench = bench;
        this.sign = sign;
        this.billboard = billboard;
        this.peg = peg;
        this.shaft = shaft;
        this.feature = feature;
    }

    public String getLamp() {
        return lamp;
    }

    public Information setLamp(String lamp) {
        this.lamp = lamp;
        return this;
    }

    public String getBucket() {
        return bucket;
    }

    public Information setBucket(String bucket) {
        this.bucket = bucket;
        return this;
    }

    public String getTree() {
        return tree;
    }

    public Information setTree(String tree) {
        this.tree = tree;
        return this;
    }

    public String getStation() {
        return station;
    }

    public Information setStation(String station) {
        this.station = station;
        return this;
    }

    public String getBench() {
        return bench;
    }

    public Information setBench(String bench) {
        this.bench = bench;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public Information setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getBillboard() {
        return billboard;
    }

    public Information setBillboard(String billboard) {
        this.billboard = billboard;
        return this;
    }

    public String getPeg() {
        return peg;
    }

    public Information setPeg(String peg) {
        this.peg = peg;
        return this;
    }

    public String getShaft() {
        return shaft;
    }

    public Information setShaft(String shaft) {
        this.shaft = shaft;
        return this;
    }

    @OneToOne
    public Feature getFeature() {
        return feature;
    }

    public Information setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }
}
