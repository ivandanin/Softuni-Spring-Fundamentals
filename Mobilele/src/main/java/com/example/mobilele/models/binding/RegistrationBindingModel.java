package com.example.mobilele.models.binding;


import javax.validation.constraints.NotNull;

public class RegistrationBindingModel {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String password;
    private String confirmPassword;
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public RegistrationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegistrationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
}
