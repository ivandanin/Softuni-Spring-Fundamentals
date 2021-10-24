package com.example.exam.services;

import com.example.exam.models.entityModels.Category;
import com.example.exam.models.entityModels.enums.CategoryEnum;

public interface CategoryService {
    void initializeCategories();

    Category findByCategory(CategoryEnum category);
}
