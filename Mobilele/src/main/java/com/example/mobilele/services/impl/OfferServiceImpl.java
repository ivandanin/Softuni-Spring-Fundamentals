package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.Offer;
import com.example.mobilele.models.viewModels.OfferDetailsView;
import com.example.mobilele.models.viewModels.OfferSummaryView;
import com.example.mobilele.repos.ModelRepo;
import com.example.mobilele.repos.OfferRepo;
import com.example.mobilele.repos.UserEntityRepo;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.OfferService;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepo offerRepo;
    private final ModelMapper modelMapper;
    private final ModelRepo modelRepo;
    private final UserEntityRepo userRepo;

    public OfferServiceImpl(OfferRepo offerRepo, ModelMapper modelMapper, ModelRepo modelRepo, UserEntityRepo userRepo) {
        this.offerRepo = offerRepo;
        this.modelMapper = modelMapper;
        this.modelRepo = modelRepo;
        this.userRepo = userRepo;
    }


    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepo.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id) {
        return this.offerRepo.findById(id).map(this::mapDetailsView).get();
    }

    private OfferSummaryView map(Offer offer) {
        return this.modelMapper.map(offer, OfferSummaryView.class);
    }

    private OfferDetailsView mapDetailsView(Offer offer) {
        OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);

        offerDetailsView.setModel(offer.getModel().getName());
        offerDetailsView.setBrand(offer.getModel().getBrand().getName());
        offerDetailsView.setSellerFullName(offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());

        return offerDetailsView;
    }
}
