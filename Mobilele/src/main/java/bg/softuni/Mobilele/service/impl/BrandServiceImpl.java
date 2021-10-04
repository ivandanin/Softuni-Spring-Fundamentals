package bg.softuni.Mobilele.service.impl;

import bg.softuni.Mobilele.model.entity.Brand;
import bg.softuni.Mobilele.repository.BrandRepository;
import bg.softuni.Mobilele.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initBrand() {

        if (brandRepository.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");
            brandRepository.save(ford);
        }
    }
}
