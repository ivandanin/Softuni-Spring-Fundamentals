package com.example.coffeeshop.web;

import com.example.coffeeshop.models.bindingModels.RegisterBindingModel;
import com.example.coffeeshop.models.serviceModels.UserServiceModel;
import com.example.coffeeshop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterBindingModel registerBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !registerBindingModel.getPassword()
                        .equals(registerBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel", bindingResult);
            return "redirect:register";
        }

        boolean isSuccessful = userService.register(modelMapper.map(registerBindingModel, UserServiceModel.class));

        if (!isSuccessful) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("usernameOccupied", true);
            return "redirect:register";
        }
        return "redirect:/";
    }
}
