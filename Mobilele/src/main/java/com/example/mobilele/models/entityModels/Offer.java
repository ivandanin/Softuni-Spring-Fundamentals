package com.example.mobilele.models.entityModels;



import com.example.mobilele.models.entityModels.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    private Integer year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private UserEntity seller;
}
