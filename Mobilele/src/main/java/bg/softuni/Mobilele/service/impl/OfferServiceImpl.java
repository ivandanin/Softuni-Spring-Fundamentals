package bg.softuni.Mobilele.service.impl;

import bg.softuni.Mobilele.model.entity.Offer;
import bg.softuni.Mobilele.model.view.OfferSummaryView;
import bg.softuni.Mobilele.repository.OfferRepository;
import bg.softuni.Mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initOffers() {

    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    private OfferSummaryView map(Offer offer) {

    OfferSummaryView summaryView = modelMapper.map(offer, OfferSummaryView.class);
        summaryView.setModel(offer.getModel().getName());

        return summaryView;
    }
}
