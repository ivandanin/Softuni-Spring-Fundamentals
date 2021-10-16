package com.example.pathfinder.models.serviceModels;

import com.example.pathfinder.models.bindingModels.LoginBindingModel;

public class LoginServiceModel {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
