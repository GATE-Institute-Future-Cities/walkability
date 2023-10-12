package com.example.map.dto.response;


import com.example.map.entity.GenderType;
import com.example.map.entity.PhysicalActivityType;
import com.example.map.entity.Role;
import com.example.map.entity.Specific;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class UserViewModel {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private LocalDate date;

    private GenderType gender;

    private PhysicalActivityType physicalActivity;

    private Set<Role> roles = new LinkedHashSet<>();

    private Set<Specific> specific = new LinkedHashSet<>();

    public UserViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserViewModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public UserViewModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public GenderType getGender() {
        return gender;
    }

    public UserViewModel setGender(GenderType gender) {
        this.gender = gender;
        return this;
    }

    public PhysicalActivityType getPhysicalActivity() {
        return physicalActivity;
    }

    public UserViewModel setPhysicalActivity(PhysicalActivityType physicalActivity) {
        this.physicalActivity = physicalActivity;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserViewModel setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Set<Specific> getSpecific() {
        return specific;
    }

    public UserViewModel setSpecific(Set<Specific> specific) {
        this.specific = specific;
        return this;
    }
}
