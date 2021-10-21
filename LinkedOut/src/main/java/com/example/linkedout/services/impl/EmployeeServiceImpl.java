package com.example.linkedout.services.impl;

import com.example.linkedout.models.entityModels.Employee;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;
import com.example.linkedout.models.serviceModels.EmployeeServiceModel;
import com.example.linkedout.repos.EmployeeRepo;
import com.example.linkedout.services.CompanyService;
import com.example.linkedout.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final CompanyService companyService;
    private final ModelMapper modelMapper;
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(CompanyService companyService, ModelMapper modelMapper, EmployeeRepo employeeRepo) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void addEmployee(EmployeeServiceModel employeeServiceModel) {

        CompanyServiceModel companyServiceModel = companyService
                .getByName(employeeServiceModel.getCompany().getName());
        employeeServiceModel.setCompany(companyServiceModel);

        Employee employee = modelMapper.map(employeeServiceModel, Employee.class);
        employeeRepo.save(employee);

    }
}
