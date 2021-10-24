package com.example.exam.web;

import com.example.exam.models.bindingModels.LoginBindingModel;
import com.example.exam.models.serviceModels.UserServiceModel;
import com.example.exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class LoginController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public LoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    private LoginBindingModel loginBindingModel() {
        return new LoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model){
        if(!model.containsAttribute("isNotFound")) {
            model.addAttribute("isNotFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginBindingModel loginBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(loginBindingModel.getUsername(), loginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("isNotFound", true);

            return "redirect:login";
        }

        userService.login(userServiceModel.getId(), loginBindingModel.getUsername());

        return "redirect:/";
    }
}
