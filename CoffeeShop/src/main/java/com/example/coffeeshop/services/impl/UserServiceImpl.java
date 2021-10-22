package com.example.coffeeshop.services.impl;

import com.example.coffeeshop.models.serviceModels.LoginServiceModel;
import com.example.coffeeshop.repositories.UserRepo;
import com.example.coffeeshop.services.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public LoginServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, LoginServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(LoginServiceModel loginServiceModel) {
        currentUser.setId(loginServiceModel.getId())
                .setUsername(loginServiceModel.getUsername());
    }
}
