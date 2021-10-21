package com.example.linkedout.models.viewModels;

public class CompanyViewModel {

    private String name;
    private String description;
    private String town;

    public String getTown() {
        return town;
    }

    public CompanyViewModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
