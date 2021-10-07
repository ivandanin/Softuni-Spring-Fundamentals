package com.example.mobilele.services;

import com.example.mobilele.models.service.LoginServiceModel;

public interface UserService {
    void initializeUsersAndRoles();

    boolean login(LoginServiceModel setPassword);

    void logout();

}
