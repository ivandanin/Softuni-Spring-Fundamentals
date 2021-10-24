package com.example.exam.web;

import com.example.exam.models.bindingModels.RegisterBindingModel;
import com.example.exam.models.serviceModels.UserServiceModel;
import com.example.exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public RegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public RegisterBindingModel registerBindingModel() {
        return new RegisterBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterBindingModel registerBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !registerBindingModel.getPassword().equals(registerBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", redirectAttributes);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel", bindingResult);

            return "redirect:register";
        }
        userService.register(modelMapper.map(registerBindingModel, UserServiceModel.class));

        return "redirect:login";
    }
}
