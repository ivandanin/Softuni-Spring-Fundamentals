package com.example.exam.services.impl;

import com.example.exam.models.entityModels.User;
import com.example.exam.models.serviceModels.UserServiceModel;
import com.example.exam.models.viewModels.ShipViewModel;
import com.example.exam.repos.ShipRepository;
import com.example.exam.repos.UserRepository;
import com.example.exam.services.UserService;
import com.example.exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ShipRepository shipRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, ShipRepository shipRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.shipRepository = shipRepository;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShipViewModel> findAllShips() {
        return shipRepository.findAllShips().stream()
                .map(ship -> {
                    ShipViewModel shipViewModel = new ShipViewModel();
                    shipViewModel.setName(ship.getName());
                    shipViewModel.getHealth(ship.getHealth());
                    shipViewModel.getPower(ship.getPower());
                    return shipViewModel;
                }).collect(Collectors.toList());
    }
}
