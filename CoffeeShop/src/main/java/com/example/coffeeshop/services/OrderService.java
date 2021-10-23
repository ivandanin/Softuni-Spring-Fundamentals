package com.example.coffeeshop.services;

import com.example.coffeeshop.models.serviceModels.OrderServiceModel;
import com.example.coffeeshop.models.viewModels.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersByPriceDescending();
}
