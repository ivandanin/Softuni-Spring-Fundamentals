package com.example.coffeeshop.models.bindingModels;

public class RegisterBindingModel {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
