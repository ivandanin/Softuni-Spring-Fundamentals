package com.example.linkedout.web;

import com.example.linkedout.models.bindingModels.AddCompanyBindingModel;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;
import com.example.linkedout.models.viewModels.CompanyDetailsViewModel;
import com.example.linkedout.models.viewModels.CompanyViewModel;
import com.example.linkedout.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;


import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addCompany(Model model) {
        if (!model.containsAttribute("addCompanyBindingModel")) {
            model.addAttribute("addCompanyBindingModel", new AddCompanyBindingModel());
            model.addAttribute("doesExist", true);
        }
        return "company-add";
    }

    @PostMapping("/add")
    public String addCompany(@Valid AddCompanyBindingModel addCompanyBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addCompanyBindingModel", addCompanyBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addCompanyBindingModel", bindingResult);

            return "redirect:add";
        }

        boolean doesExist = companyService.addCompany(modelMapper.map(addCompanyBindingModel, CompanyServiceModel.class));

        if (!doesExist) {
            redirectAttributes.addFlashAttribute("addCompanyBindingModel", addCompanyBindingModel)
                    .addFlashAttribute("doesExist", false);
            return "redirect:add";
        }
        httpSession.setAttribute("recentlyUpdated",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")));

        return "redirect:/";
    }

    @GetMapping("/all")
    public String allCompanies(Model model) {
        model.addAttribute("companies",
                companyService.findAll().stream()
        .map(companyServiceModel ->
                modelMapper.map(companyServiceModel, CompanyViewModel.class))
        .collect(Collectors.toList()));
        return "company-all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("company", modelMapper.map(companyService.findById(id), CompanyDetailsViewModel.class));
        return "company-details";
    }
}
