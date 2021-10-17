package com.example.pathfinder.services;

import com.example.pathfinder.models.serviceModels.UserServiceModel;

public interface UserService {

    void login(Long id, String username);

    void register(UserServiceModel map);

    void logout();

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    UserServiceModel findById(Long id);

    boolean doesExist(String username);
}
