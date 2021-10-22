package com.example.coffeeshop.models.bindingModels;

import com.example.coffeeshop.models.entityModels.enums.CategoryEnum;

import java.math.BigDecimal;

public class OrderBindingModel {

    private String name;
    private BigDecimal price;
    private Integer orderTime;
    private String category;
    private String description;

    public OrderBindingModel() {
    }

    public String getName() {
        return name;
    }

    public OrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public OrderBindingModel setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OrderBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
