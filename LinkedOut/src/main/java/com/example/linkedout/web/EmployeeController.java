package com.example.linkedout.web;

import com.example.linkedout.models.bindingModels.AddEmployeeBindingModel;
import com.example.linkedout.models.serviceModels.EmployeeServiceModel;
import com.example.linkedout.models.viewModels.AddEmployeeViewModel;
import com.example.linkedout.services.CompanyService;
import com.example.linkedout.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AddEmployeeBindingModel addModel() {
        return new AddEmployeeBindingModel();
    }

    @GetMapping("/all")
    public String allEmployees(Model model) {
        return "employee-all";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        if (!model.containsAttribute("addEmployeeBindingModel")) {
            model.addAttribute("addEmployeeBindingModel", new AddEmployeeBindingModel());
        }
        model.addAttribute("companies",
                companyService.findAll().stream()
                .map(company -> modelMapper.map(company, AddEmployeeViewModel.class))
                .collect(Collectors.toList()));

        return "employee-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddEmployeeBindingModel addEmployeeBindingModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEmployeeBindingModel", addEmployeeBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeBindingModel", bindingResult);
            return "redirect:add";
        }

        this.employeeService.save(addEmployeeBindingModel);

        return "redirect:/";
    }
}
