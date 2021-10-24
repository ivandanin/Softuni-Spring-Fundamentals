package com.example.exam.services.impl;

import com.example.exam.models.entityModels.Category;
import com.example.exam.models.entityModels.enums.CategoryEnum;
import com.example.exam.repos.CategoryRepository;
import com.example.exam.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(CategoryEnum.BATTLE, "battle"));
            categoryRepository.save(new Category(CategoryEnum.CARGO, "cargo"));
            categoryRepository.save(new Category(CategoryEnum.PATROL, "patrol"));
        }
    }

    @Override
    public Category findByCategory(CategoryEnum category) {
        return categoryRepository.findByName(category)
                .orElse(null);
    }
}
