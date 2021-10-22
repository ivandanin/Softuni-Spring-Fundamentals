package com.example.linkedout.services;

import com.example.linkedout.models.bindingModels.AddEmployeeBindingModel;
import com.example.linkedout.models.serviceModels.EmployeeServiceModel;

public interface EmployeeService {
    void addEmployee(EmployeeServiceModel employeeServiceModel);

    void save(AddEmployeeBindingModel addEmployeeBindingModel);
}
