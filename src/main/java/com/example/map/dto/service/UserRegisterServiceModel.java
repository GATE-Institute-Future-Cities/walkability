package com.example.map.dto.service;

import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRegisterServiceModel {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String date;
    private String password;
    private String confirmPassword;
    private String gender;
    private String physicalActivity;
    private List<String> specific = new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDate() {
        return date;
    }

    public UserRegisterServiceModel setDate(String date) {
        this.date = date;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterServiceModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserRegisterServiceModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public UserRegisterServiceModel setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
        return this;
    }

    public List<String> getSpecific() {
        return specific;
    }

    public UserRegisterServiceModel setSpecific(List<String> specific) {
        this.specific = specific;
        return this;
    }
}
