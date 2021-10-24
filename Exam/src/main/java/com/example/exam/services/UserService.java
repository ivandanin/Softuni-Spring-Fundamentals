package com.example.exam.services;

import com.example.exam.models.entityModels.User;
import com.example.exam.models.serviceModels.UserServiceModel;
import com.example.exam.models.viewModels.ShipViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(Long id, String username);

    UserServiceModel register(UserServiceModel userServiceModel);

    User findById(Long id);

    List<ShipViewModel> findAllShips();
}
