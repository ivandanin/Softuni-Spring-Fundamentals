package com.example.coffeeshop.models.bindingModels;

import javax.validation.constraints.Size;

public class LoginBindingModel {


    @Size(min = 5, max = 20,message = "Username length must be between 5 and 20 characters.")
    private String username;
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
