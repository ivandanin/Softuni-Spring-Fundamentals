package bg.softuni.Mobilele.model.entity;

import bg.softuni.Mobilele.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum category;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer startYear;
    private Integer endYear;

    @ManyToOne
    private Brand brand;

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
