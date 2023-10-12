package com.example.map.dto.binding;

import jakarta.validation.constraints.Min;

import java.util.*;

public class UserRegisterBindingModel {

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

    //private Set<String> role;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDate() {
        return date;
    }

    public UserRegisterBindingModel setDate(String date) {
        this.date = date;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

//    public Set<String> getRole() {
//        return role;
//    }
//
//    public UserRegisterBindingModel setRole(Set<String> role) {
//        this.role = role;
//        return this;
//    }


    public String getGender() {
        return gender;
    }

    public UserRegisterBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public UserRegisterBindingModel setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
        return this;
    }

    public List<String> getSpecific() {
        return specific;
    }

    public UserRegisterBindingModel setSpecific(List<String> specific) {
        this.specific = specific;
        return this;
    }
}
