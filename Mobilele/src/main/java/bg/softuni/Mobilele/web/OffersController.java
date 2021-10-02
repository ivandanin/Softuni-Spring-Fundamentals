package bg.softuni.Mobilele.web;

import bg.softuni.Mobilele.service.OfferService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class OffersController {

    private final OfferService offerService;


    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",
                offerService.getAllOffers());
        return "offers";
    }
}
