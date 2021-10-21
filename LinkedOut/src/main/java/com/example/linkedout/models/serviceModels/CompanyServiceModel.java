package com.example.linkedout.models.serviceModels;

import java.math.BigDecimal;

public class CompanyServiceModel {

    private Long id;
    private BigDecimal budget;
    private String description;
    private String name;
    private String town;

    public String getName() {
        return name;
    }

    public CompanyServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CompanyServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public CompanyServiceModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyServiceModel setTown(String town) {
        this.town = town;
        return this;
    }
}
