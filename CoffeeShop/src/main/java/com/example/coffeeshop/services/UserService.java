package com.example.coffeeshop.services;

import com.example.coffeeshop.models.serviceModels.LoginServiceModel;

public interface UserService {
    LoginServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(LoginServiceModel loginServiceModel);
}
