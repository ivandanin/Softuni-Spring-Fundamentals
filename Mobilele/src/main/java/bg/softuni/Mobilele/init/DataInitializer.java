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

        if (brandRepository.count() == 0) {
            Brand ford = new Brand().setName("Ford");

            Model fiesta = new Model();
            fiesta.setImageUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.motopfohe.bg%2Ffiles%2Fnews%2Farchive%2F2017%2F08%2Fblob-server.jpg&imgrefurl=https%3A%2F%2Fwww.motopfohe.bg%2Fbg%2Fabout-us%2Fnews%2Fview%2Fizcqlo-noviqt-ford-fiesta-naj-tehnologichniqt-malyk-avtomobil-na-pazara-v-evropa&tbnid=LMsCDyDhykHFZM&vet=12ahUKEwiL6c3n26vzAhXNxrsIHfRtBVsQMygBegUIARCrAQ..i&docid=6Sy90h4HcaE6WM&w=780&h=439&q=fiesta&ved=2ahUKEwiL6c3n26vzAhXNxrsIHfRtBVsQMygBegUIARCrAQ");
            fiesta.setStartYear(1976);
            fiesta.setCategory(CategoryEnum.CAR);

            Model escort = new Model();
            fiesta.setImageUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fe%2Fe9%2F1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFord_Escort_RS_Cosworth&tbnid=WwGNLJx9HtRVhM&vet=12ahUKEwjG38G43KvzAhUg47sIHflxDlAQMygAegUIARCvAQ..i&docid=8VYNp3AyDFiBmM&w=4576&h=2777&q=ford%20escort%20rs&ved=2ahUKEwjG38G43KvzAhUg47sIHflxDlAQMygAegUIARCvAQ");
            fiesta.setStartYear(1968);
            fiesta.setEndYear(2002);
            fiesta.setCategory(CategoryEnum.CAR);

            ford.setModels(List.of(fiesta, escort));
            fiesta.setBrand(ford);
            escort.setBrand(ford);

            brandRepository.save(ford);
        }
    }
}
