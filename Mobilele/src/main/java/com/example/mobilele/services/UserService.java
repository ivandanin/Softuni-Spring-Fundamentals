package com.example.mobilele.services;

import com.example.mobilele.models.service.LoginServiceModel;
import com.example.mobilele.models.service.RegistrationServiceModel;

public interface UserService {
    void initializeUsersAndRoles();

    boolean login(LoginServiceModel setPassword);

    void logout();

    void registerAndLoginUser(RegistrationServiceModel serviceModel);

    boolean isUserNameFree(String username);
}
