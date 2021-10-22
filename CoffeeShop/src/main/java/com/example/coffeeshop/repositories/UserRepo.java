package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.User;
import com.example.coffeeshop.models.serviceModels.LoginServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findById(Long id);
}
