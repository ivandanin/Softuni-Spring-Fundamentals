package com.example.pathfinder.services;

import com.example.pathfinder.models.serviceModels.RouteServiceModel;

import java.util.List;

public interface RouteService {
    RouteServiceModel findRouteById(Long id);

    List<RouteServiceModel> findAllRoutes();
}
