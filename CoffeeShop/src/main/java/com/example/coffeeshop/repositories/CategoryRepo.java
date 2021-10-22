package com.example.coffeeshop.repositories;

import com.example.coffeeshop.models.entityModels.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
