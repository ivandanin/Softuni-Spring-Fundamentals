package com.example.coffeeshop.models.serviceModels;

public class RegisterServiceModel {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confPassword;

    public RegisterServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RegisterServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public RegisterServiceModel setConfPassword(String confPassword) {
        this.confPassword = confPassword;
        return this;
    }
}
