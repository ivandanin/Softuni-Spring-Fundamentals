package com.example.linkedout.services;

import com.example.linkedout.models.entityModels.Company;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;

import java.util.List;

public interface CompanyService {

    boolean addCompany(CompanyServiceModel serviceModel);

    List<Company> findAll();
}
