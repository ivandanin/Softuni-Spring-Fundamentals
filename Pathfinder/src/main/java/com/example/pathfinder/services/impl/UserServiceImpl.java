package com.example.pathfinder.services.impl;

import com.example.pathfinder.models.serviceModels.LoginServiceModel;
import com.example.pathfinder.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(LoginServiceModel loginServiceModel) {
        return false;
    }
}
