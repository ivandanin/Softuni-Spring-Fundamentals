package com.example.mobilele.services.impl;

import com.example.mobilele.models.serviceModels.LoginServiceModel;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.UserEntityService;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Override
    public void initializeUsersAndRoles() {

    }

    @Override
    public boolean login(LoginServiceModel loginServiceModel) {
        return false;
    }
}
