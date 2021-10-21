package com.example.linkedout.models.viewModels;

public class AddEmployeeViewModel {

    private String name;

    public AddEmployeeViewModel() {
    }

    public String getName() {
        return name;
    }

    public AddEmployeeViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
