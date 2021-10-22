package com.example.coffeeshop.services.impl;

import com.example.coffeeshop.models.entityModels.Order;
import com.example.coffeeshop.models.serviceModels.OrderServiceModel;
import com.example.coffeeshop.repositories.OrderRepo;
import com.example.coffeeshop.services.CategoryService;
import com.example.coffeeshop.services.OrderService;
import com.example.coffeeshop.services.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepo orderRepo;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public OrderServiceImpl(ModelMapper modelMapper, OrderRepo orderRepo, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.orderRepo = orderRepo;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);

        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByName(orderServiceModel.getCategory()));

        orderRepo.save(order);
    }
}
