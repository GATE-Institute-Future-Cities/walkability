package com.example.map.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity{

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

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String email, LocalDate date, GenderType gender, PhysicalActivityType physicalActivity, Set<Role> roles, Set<Specific> specific) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date = date;
        this.gender = gender;
        this.physicalActivity = physicalActivity;
        this.roles = roles;
        this.specific = specific;
    }

    public User(String firstName, String lastName, String username, String password, String email, LocalDate date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date = date;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    @Column(nullable = false, columnDefinition = "DATE")
    public LocalDate getDate() {
        return date;
    }

    public User setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public GenderType getGender() {
        return gender;
    }

    public User setGender(GenderType gender) {
        this.gender = gender;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PhysicalActivityType getPhysicalActivity() {
        return physicalActivity;
    }

    public User setPhysicalActivity(PhysicalActivityType physicalActivity) {
        this.physicalActivity = physicalActivity;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Specific> getSpecific() {
        return specific;
    }

    public User setSpecific(Set<Specific> specific) {
        this.specific = specific;
        return this;
    }
}
