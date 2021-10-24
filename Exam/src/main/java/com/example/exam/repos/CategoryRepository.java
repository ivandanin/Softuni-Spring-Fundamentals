package com.example.exam.repos;

import com.example.exam.models.entityModels.Category;
import com.example.exam.models.entityModels.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryEnum category);
}
