package com.example.exam.models.bindingModels;

import com.example.exam.models.entityModels.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddShipBindingModel {

    @Size(min = 2, max = 10, message = "The name must be between 2 and 10 characters!")
    private String name;

    @NotNull(message = "Power cannot be null!")
    @Positive(message = "The power must be positive!")
    private Integer power;

    @NotNull(message = "Health cannot be null!")
    @Positive(message = "The health must be positive!")
    private Integer health;

    @PastOrPresent(message = "Created date cannot be in future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull(message = "You must select category!")
    private CategoryEnum category;

    public AddShipBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddShipBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public AddShipBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public AddShipBindingModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public AddShipBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public AddShipBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
