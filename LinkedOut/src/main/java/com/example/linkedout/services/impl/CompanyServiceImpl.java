package com.example.linkedout.services.impl;

import com.example.linkedout.models.entityModels.Company;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;
import com.example.linkedout.repos.CompanyRepo;
import com.example.linkedout.services.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public boolean doesExist(String name) {
        return companyRepo.findByName(name).isPresent();
    }

    @Override
    public void addCompany(CompanyServiceModel serviceModel) {
        Company newCompany = new Company();

        newCompany.setName(serviceModel.getName())
                .setTown(serviceModel.getTown())
                .setDescription(serviceModel.getDescription())
                .setBudget(serviceModel.getBudget());

        companyRepo.save(newCompany);
    }
}
