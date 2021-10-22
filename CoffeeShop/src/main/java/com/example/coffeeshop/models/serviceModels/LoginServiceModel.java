package com.example.coffeeshop.models.serviceModels;

public class LoginServiceModel {

    private Long id;
    private String username;
    private String password;

    public LoginServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public LoginServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

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
