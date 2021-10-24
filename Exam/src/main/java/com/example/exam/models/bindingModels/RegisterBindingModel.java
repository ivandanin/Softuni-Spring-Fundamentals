package com.example.exam.models.bindingModels;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class RegisterBindingModel {

    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters!")
    private String username;

    @Size(min = 5, max = 20, message = "Full name must be between 5 and 20 characters!")
    private String fullName;

    @Email(message = "Enter valid email address!")
    private String email;

    @Size(min = 3, message = "Password must be more than least 3 characters!")
    private String password;

    @Size(min = 3, message = "Password must be more than least 3 characters!")
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

    public String getFullName() {
        return fullName;
    }

    public RegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
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
