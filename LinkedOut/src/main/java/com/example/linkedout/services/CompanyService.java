package com.example.linkedout.services;

import com.example.linkedout.models.entityModels.Company;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    boolean addCompany(CompanyServiceModel serviceModel);

    List<Company> findAll();

    CompanyServiceModel findById(String id);

    CompanyServiceModel getByName(String name);
}
