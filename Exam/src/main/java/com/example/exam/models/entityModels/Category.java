package com.example.exam.models.entityModels;

import com.example.exam.models.entityModels.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private CategoryEnum name;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String description;

    public Category(CategoryEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {

    }

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

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
