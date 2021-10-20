package com.example.linkedout.models.bindingModels;

import java.math.BigDecimal;

public class AddCompanyBindingModel {

    private String name;
    private BigDecimal budget;
    private String description;
    private String town;

    public String getName() {
        return name;
    }

    public AddCompanyBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public AddCompanyBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddCompanyBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTown() {
        return town;
    }

    public AddCompanyBindingModel setTown(String town) {
        this.town = town;
        return this;
    }
}
