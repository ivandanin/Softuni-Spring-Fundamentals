package com.example.linkedout.web;

import com.example.linkedout.models.bindingModels.AddEmployeeBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

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
        return "employee-add";
    }
}
