package com.example.coffeeshop.services;

import com.example.coffeeshop.models.serviceModels.LoginServiceModel;
import com.example.coffeeshop.models.serviceModels.RegisterServiceModel;

public interface UserService {
    LoginServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(LoginServiceModel loginServiceModel);

    boolean register(RegisterServiceModel registerServiceModel);

    void logout();
}
