package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.Brand;
import com.example.mobilele.models.entityModels.Model;
import com.example.mobilele.models.entityModels.enums.CategoryEnum;
import com.example.mobilele.repos.BrandRepo;
import com.example.mobilele.repos.ModelRepo;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.ModelService;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final BrandRepo brandRepo;
    private final ModelRepo modelRepo;

    public ModelServiceImpl(BrandRepo brandRepo, ModelRepo modelRepo) {
        this.brandRepo = brandRepo;
        this.modelRepo = modelRepo;
    }

    @Override
    public void initializeModels() {
        Brand ford = brandRepo.findByName("Ford")
                .orElseThrow(IllegalArgumentException::new);

        Model fiesta = new Model();
        fiesta.setName("Fiesta");
        fiesta.setCategory(CategoryEnum.CAR);
        fiesta.setImageUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fassets.whichcar.com.au%2Fimage%2Fprivate%2Fs--vHj10JRF--%2Far_2.304921968787515%2Cc_fill%2Cf_auto%2Cg_xy_center%2Cq_auto%3Agood%2Cx_3000%2Cy_2000%2Fv1%2FMotor%2FFeatures%2FFiesta_RS_front.png&imgrefurl=https%3A%2F%2Fwww.whichcar.com.au%2Ffeatures%2Fsweet-dream-ford-fiesta-rs&tbnid=g9XH2FmcTgdSlM&vet=12ahUKEwiuibH9yL3zAhXN57sIHWJPDOYQMygEegUIARCsAQ..i&docid=fY_ka-GVsCPJUM&w=6000&h=2603&q=ford%20fiesta%20rs&ved=2ahUKEwiuibH9yL3zAhXN57sIHWJPDOYQMygEegUIARCsAQ");
        fiesta.setStartYear(1976);
        fiesta.setBrand(ford);

        Model escort = new Model();
        escort.setName("Escort");
        escort.setCategory(CategoryEnum.CAR);
        escort.setImageUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fe%2Fe9%2F1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFord_Escort_RS_Cosworth&tbnid=WwGNLJx9HtRVhM&vet=12ahUKEwjfhJqIyb3zAhXLi_0HHc0tDd0QMygAegUIARCwAQ..i&docid=8VYNp3AyDFiBmM&w=4576&h=2777&q=ford%20escort%20rs&ved=2ahUKEwjfhJqIyb3zAhXLi_0HHc0tDd0QMygAegUIARCwAQ");
        escort.setStartYear(1967);
        escort.setEndYear(2002);
        escort.setBrand(ford);

        modelRepo.saveAll(List.of(fiesta, escort)); // makes IllegalStateException
    }

    @Override
    public Model findById(Long id) {
        return modelRepo.findById(id).orElse(null);
    }
}
