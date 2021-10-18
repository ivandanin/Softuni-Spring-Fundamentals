package com.example.pathfinder.services.impl;

import com.example.pathfinder.models.entityModels.Route;
import com.example.pathfinder.models.serviceModels.RouteServiceModel;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.services.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RouteServiceModel findRouteById(Long id) {
        Route route = this.routeRepository.findById(id).orElse(null);

        return modelMapper.map(route, RouteServiceModel.class);
    }

    @Override
    public List<RouteServiceModel> findAllRoutes() {
        List<Route> routes = this.routeRepository.findAll();
        return routes.stream()
                .map(route -> modelMapper.map(route, RouteServiceModel.class))
                .collect(Collectors.toList());
    }
}
