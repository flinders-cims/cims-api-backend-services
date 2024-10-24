package com.flinders.cims.model;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private String emailId;
    private long phoneNumber;
    private String managerUserName;
    private String higherApproverUsername;

    public String getHigherApproverUsername() {
        return higherApproverUsername;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmailId() {
        return emailId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getManagerUserName() {
        return managerUserName;
    }
}

