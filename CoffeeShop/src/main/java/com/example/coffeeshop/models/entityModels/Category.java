package com.example.coffeeshop.models.entityModels;

import com.example.coffeeshop.models.entityModels.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CategoryEnum name;
    private Integer neededTime;

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
