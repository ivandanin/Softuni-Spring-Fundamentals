package com.example.linkedout.models.bindingModels;

import com.example.linkedout.models.entityModels.Company;
import com.example.linkedout.models.entityModels.enums.EducationalLevelEnum;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddEmployeeBindingModel {

    private String id;
    private LocalDate birthday;
    private EducationalLevelEnum educationLevel;
    private String firstName;
    private String jobTitle;
    private String lastName;
    private BigDecimal salary;
    private Company company;

    public AddEmployeeBindingModel() {
    }

    public String getId() {
        return id;
    }

    public AddEmployeeBindingModel setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public AddEmployeeBindingModel setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public EducationalLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public AddEmployeeBindingModel setEducationLevel(EducationalLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AddEmployeeBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public AddEmployeeBindingModel setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddEmployeeBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public AddEmployeeBindingModel setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public AddEmployeeBindingModel setCompany(Company company) {
        this.company = company;
        return this;
    }
}
