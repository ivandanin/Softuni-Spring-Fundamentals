package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
