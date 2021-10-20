package com.example.linkedout.services;

import com.example.linkedout.models.serviceModels.CompanyServiceModel;

public interface CompanyService {

    boolean doesExist(String name);

    void addCompany(CompanyServiceModel serviceModel);

}
