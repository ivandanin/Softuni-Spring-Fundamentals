package bg.softuni.Mobilele.service.impl;

import bg.softuni.Mobilele.model.entity.Brand;
import bg.softuni.Mobilele.model.entity.Model;
import bg.softuni.Mobilele.model.entity.enums.CategoryEnum;
import bg.softuni.Mobilele.repository.BrandRepository;
import bg.softuni.Mobilele.repository.ModelRepository;
import bg.softuni.Mobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void initModels() {
        Brand ford = brandRepository.findByName("Ford")
                .orElseThrow(IllegalArgumentException::new);

        Model fiesta = new Model();
        fiesta.setName("Fiesta");
        fiesta.setBrand(ford);
        fiesta.setImageUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.motopfohe.bg%2Ffiles%2Fnews%2Farchive%2F2017%2F08%2Fblob-server.jpg&imgrefurl=https%3A%2F%2Fwww.motopfohe.bg%2Fbg%2Fabout-us%2Fnews%2Fview%2Fizcqlo-noviqt-ford-fiesta-naj-tehnologichniqt-malyk-avtomobil-na-pazara-v-evropa&tbnid=LMsCDyDhykHFZM&vet=12ahUKEwiL6c3n26vzAhXNxrsIHfRtBVsQMygBegUIARCrAQ..i&docid=6Sy90h4HcaE6WM&w=780&h=439&q=fiesta&ved=2ahUKEwiL6c3n26vzAhXNxrsIHfRtBVsQMygBegUIARCrAQ");
        fiesta.setStartYear(1976);
        fiesta.setCategory(CategoryEnum.CAR);

        Model escort = new Model();
        escort.setName("Escort");
        escort.setBrand(ford);
        escort.setImageUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fe%2Fe9%2F1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFord_Escort_RS_Cosworth&tbnid=WwGNLJx9HtRVhM&vet=12ahUKEwjG38G43KvzAhUg47sIHflxDlAQMygAegUIARCvAQ..i&docid=8VYNp3AyDFiBmM&w=4576&h=2777&q=ford%20escort%20rs&ved=2ahUKEwjG38G43KvzAhUg47sIHflxDlAQMygAegUIARCvAQ");
        escort.setStartYear(1968);
        escort.setEndYear(2002);
        escort.setCategory(CategoryEnum.CAR);

        modelRepository.saveAll(List.of(fiesta, escort));
    }
}
