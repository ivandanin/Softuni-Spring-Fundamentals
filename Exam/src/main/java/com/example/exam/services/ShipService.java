package com.example.exam.services;

import com.example.exam.models.serviceModels.ShipServiceModel;
import com.example.exam.models.viewModels.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findAllShipsByHealthDesc();
}
