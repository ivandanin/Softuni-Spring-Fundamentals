package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
