package com.example.exam.models.bindingModels;

import javax.validation.constraints.Size;

public class LoginBindingModel {

    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters!")
    private String username;

    @Size(min = 3, message = "Password must be at least 3 characters!")
    private String password;

    public LoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public LoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
