package com.example.linkedout.services.impl;

import com.example.linkedout.models.entityModels.Company;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;
import com.example.linkedout.repos.CompanyRepo;
import com.example.linkedout.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepo companyRepo, ModelMapper modelMapper) {
        this.companyRepo = companyRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addCompany(CompanyServiceModel serviceModel) {
        if (companyRepo.findByName(serviceModel.getName()).isPresent()) {
            return false;
        }
        Company newCompany = modelMapper.map(serviceModel, Company.class);
        companyRepo.save(newCompany);

        return true;
    }

    @Override
    public List<Company> findAll() {
        return new ArrayList<>(companyRepo.findAll());
    }
}
