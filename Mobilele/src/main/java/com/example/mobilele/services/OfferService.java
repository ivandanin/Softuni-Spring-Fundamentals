package com.example.mobilele.services;

import com.example.mobilele.models.viewModels.OfferDetailsView;
import com.example.mobilele.models.viewModels.OfferSummaryView;

import java.util.List;

public interface OfferService {
    default void initializeOffers() {

    }

    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findById(Long id);
}
