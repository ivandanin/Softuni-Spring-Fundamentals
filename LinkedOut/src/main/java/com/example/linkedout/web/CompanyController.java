package com.example.linkedout.web;

import com.example.linkedout.models.bindingModels.AddCompanyBindingModel;
import com.example.linkedout.models.serviceModels.CompanyServiceModel;
import com.example.linkedout.models.viewModels.CompanyViewModel;
import com.example.linkedout.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AddCompanyBindingModel addCompanyBindingModel() {
        return new AddCompanyBindingModel();
    }

    @GetMapping("/add")
    public String addCompany(Model model) {
        model.addAttribute("exists", true);
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
}
