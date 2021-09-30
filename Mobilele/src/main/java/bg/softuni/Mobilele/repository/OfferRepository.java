package bg.softuni.Mobilele.repository;

import bg.softuni.Mobilele.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
