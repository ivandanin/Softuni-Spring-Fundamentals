package com.example.coffeeshop.services;

import com.example.coffeeshop.models.entityModels.Category;
import com.example.coffeeshop.models.entityModels.enums.CategoryEnum;

public interface CategoryService {
    Category findByName(Category category);
}
