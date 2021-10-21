package com.example.linkedout.models.viewModels;

public class CompanyDetailsViewModel {
    private String id;
    private String description;
    private String name;
    private String town;
    private String budget;

    public CompanyDetailsViewModel() {
    }

    public String getId() {
        return id;
    }

    public CompanyDetailsViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyDetailsViewModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getBudget() {
        return budget;
    }

    public CompanyDetailsViewModel setBudget(String budget) {
        this.budget = budget;
        return this;
    }
}
