package com.example.linkedout.models.serviceModels;

import com.example.linkedout.models.entityModels.enums.EducationalLevelEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeServiceModel {
    private String id;
    private LocalDate birthday;
    private EducationalLevelEnum educationLevel;
    private String firstName;
    private String jobTitle;
    private String lastName;
    private BigDecimal salary;
    private CompanyServiceModel company;

    public EmployeeServiceModel() {
    }

    public String getId() {
        return id;
    }

    public EmployeeServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public EmployeeServiceModel setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public EducationalLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public EmployeeServiceModel setEducationLevel(EducationalLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeServiceModel setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public EmployeeServiceModel setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public EmployeeServiceModel setCompany(CompanyServiceModel company) {
        this.company = company;
        return this;
    }
}
