package com.example.coffeeshop.services;

import com.example.coffeeshop.models.entityModels.User;
import com.example.coffeeshop.models.serviceModels.UserServiceModel;
import com.example.coffeeshop.models.viewModels.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(UserServiceModel loginServiceModel);

    boolean register(UserServiceModel registerServiceModel);

    void logout();

    User findById(Long id);

    List<UserViewModel> findAllUsersAndOrderCountDescending();
}
