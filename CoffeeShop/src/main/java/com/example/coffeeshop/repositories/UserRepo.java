package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.User;
import com.example.coffeeshop.models.viewModels.UserViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findById(Long id);


    @Query("SELECT u FROM User AS u ORDER BY SIZE(u.orders) DESC")
    List<UserViewModel> findAllByOrdersDescending();
}
