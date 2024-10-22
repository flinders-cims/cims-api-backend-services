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

    @Column(name = "manager_user_name", nullable = false, length = 100)  // Customize constraints
    private String managerUserName;

    @Column(name = "first_name", nullable = false, length = 100)  // Adding firstName column
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)  // Adding lastName column
    private String lastName;

    @Column(name = "password", nullable = false, length = 255)  // Customize column length
    private String password;

    @Column(name = "role", nullable = false, length = 50)  // Customize role field
    private String role;

    @Column(name = "email_id", nullable = false, length = 50)  // Customize role field
    private String emailId;

    @Column(name = "phone_number", nullable = false)  // Customize column name and set nullable constraint
    private long phoneNumber;

    @Column(name = "higher_approver_user_name", nullable = false)  // Customize column name and set nullable constraint
    private String higherApproverUsername;

    public void setHigherApproverUsername(String higherApproverUsername) {
        this.higherApproverUsername = higherApproverUsername;
    }

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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getManagerUserName() {
        return managerUserName;
    }

    public void setManagerUserName(String managerUserName) {
        this.managerUserName = managerUserName;
    }
}
