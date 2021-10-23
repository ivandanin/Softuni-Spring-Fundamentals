package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.Category;
import com.example.coffeeshop.models.entityModels.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryEnum category);
}
