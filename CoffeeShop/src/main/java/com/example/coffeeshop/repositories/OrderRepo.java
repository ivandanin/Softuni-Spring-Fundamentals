package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
