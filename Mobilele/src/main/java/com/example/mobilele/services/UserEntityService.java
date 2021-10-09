package com.example.mobilele.services;

import com.example.mobilele.models.serviceModels.LoginServiceModel;

public interface UserEntityService {
    void initializeUsersAndRoles();

    boolean login(LoginServiceModel loginServiceModel);
}
