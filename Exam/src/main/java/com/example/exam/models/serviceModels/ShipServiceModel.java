package com.example.exam.models.serviceModels;

import com.example.exam.models.entityModels.User;
import com.example.exam.models.entityModels.enums.CategoryEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipServiceModel {

    private Long id;
    private String name;
    private Integer power;
    private Integer health;
    private LocalDate created;
    private CategoryEnum category;
    private User user;

    public ShipServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipServiceModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipServiceModel setUser(User user) {
        this.user = user;
        return this;
    }
}
