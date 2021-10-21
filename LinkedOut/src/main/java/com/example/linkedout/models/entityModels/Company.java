package com.example.linkedout.models.entityModels;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private BigDecimal budget;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String town;

    @OneToMany
    private Set<Employee> employees;

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Company setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Company setTown(String town) {
        this.town = town;
        return this;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Company setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }

}
