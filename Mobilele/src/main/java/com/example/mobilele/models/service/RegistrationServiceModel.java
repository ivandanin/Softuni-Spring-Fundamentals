package com.example.mobilele.models.service;

public class RegistrationServiceModel {

    private String firstName;
    private String lastName;
    private String password;
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public RegistrationServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegistrationServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegistrationServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }
}
