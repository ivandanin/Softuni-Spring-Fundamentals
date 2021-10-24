package com.example.exam.models.viewModels;

public class ShipViewModel {

    private Long id;
    private String name;
    private Integer health;
    private Integer power;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHealth(Integer health) {
        return this.health;
    }

    public ShipViewModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getPower(Integer power) {
        return this.power;
    }

    public ShipViewModel setPower(Integer power) {
        this.power = power;
        return this;
    }
}
