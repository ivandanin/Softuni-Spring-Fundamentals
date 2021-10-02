package bg.softuni.Mobilele.model.entity;

import bg.softuni.Mobilele.model.entity.enums.EngineEnum;
import bg.softuni.Mobilele.model.entity.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    private int year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
