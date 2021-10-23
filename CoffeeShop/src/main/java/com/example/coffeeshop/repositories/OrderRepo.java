package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.Order;
import com.example.coffeeshop.models.viewModels.OrderViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findAllOrdersByPriceOrderByPriceDesc();
}
