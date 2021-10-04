package bg.softuni.Mobilele.init;

import bg.softuni.Mobilele.model.entity.Brand;
import bg.softuni.Mobilele.model.entity.Model;
import bg.softuni.Mobilele.model.entity.enums.CategoryEnum;
import bg.softuni.Mobilele.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public DataInitializer(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args){

    }
}
