package com.example.mobilele.models.viewModels;

import com.example.mobilele.models.entityModels.Model;
import com.example.mobilele.models.entityModels.UserEntity;
import com.example.mobilele.models.entityModels.enums.TransmissionEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class OfferDetailsView {

    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String description;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private Integer year;
    private String model;
    private String brand;
    private String sellerFullName;


    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferDetailsView setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDetailsView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public OfferDetailsView setSellerFullName(String fullName) {
        this.sellerFullName = fullName;
        return this;
    }
}
