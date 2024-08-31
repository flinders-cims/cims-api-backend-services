package com.flinders.cims.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)  // Customize column name
    private int userId;

    @Column(name = "user_name", nullable = false, unique = true, length = 100)  // Customize constraints
    private String username;

    @Column(name = "password", nullable = false, length = 255)  // Customize column length
    private String password;

    @Column(name = "role", nullable = false, length = 50)  // Customize role field
    private String role;

    @Column(name = "phone_number", nullable = false)  // Customize column name and set nullable constraint
    private int phoneNumber;

    @Column(name = "first_name", nullable = false, length = 100)  // Adding firstName column
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)  // Adding lastName column
    private String lastName;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
