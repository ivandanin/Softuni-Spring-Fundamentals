package bg.softuni.Mobilele.service;

import bg.softuni.Mobilele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initOffers();

    List<OfferSummaryView> getAllOffers();
}
