package com.example.coffeeshop.services.impl;

import com.example.coffeeshop.models.entityModels.Category;

import com.example.coffeeshop.models.entityModels.enums.CategoryEnum;
import com.example.coffeeshop.repositories.CategoryRepo;
import com.example.coffeeshop.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category findByName(CategoryEnum category) {
        return categoryRepo.findByName(category).orElse(null);
    }


}
