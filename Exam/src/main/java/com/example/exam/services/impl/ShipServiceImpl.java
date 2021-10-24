package com.example.exam.services.impl;

import com.example.exam.models.entityModels.Ship;
import com.example.exam.models.serviceModels.ShipServiceModel;
import com.example.exam.models.viewModels.ShipViewModel;
import com.example.exam.repos.ShipRepository;
import com.example.exam.services.CategoryService;
import com.example.exam.services.ShipService;
import com.example.exam.services.UserService;
import com.example.exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository,
                           CurrentUser currentUser,
                           ModelMapper modelMapper,
                           UserService userService,
                           CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);

        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategory(shipServiceModel.getCategory()));
        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findAllShipsByHealthDesc() {
        return shipRepository.findAllShipsOrderByHealthDesc()
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }
}
