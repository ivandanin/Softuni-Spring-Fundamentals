package com.example.mobilele.services.impl;

import com.example.mobilele.models.service.LoginServiceModel;
import com.example.mobilele.models.service.RegistrationServiceModel;
import com.example.mobilele.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void initializeUsersAndRoles() {

    }

    @Override
    public boolean login(LoginServiceModel setPassword) {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public void registerAndLoginUser(RegistrationServiceModel serviceModel) {

    }

    @Override
    public boolean isUserNameFree(String username) {
        return false;
    }
}
