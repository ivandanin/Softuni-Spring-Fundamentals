package com.example.coffeeshop.models.serviceModels;

import com.example.coffeeshop.models.entityModels.Category;

import java.math.BigDecimal;

public class OrderServiceModel {

    private String name;
    private BigDecimal price;
    private Integer orderTime;
    private Category category;
    private String description;

    public OrderServiceModel() {
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
