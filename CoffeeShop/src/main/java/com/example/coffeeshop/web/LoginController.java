package com.example.coffeeshop.web;

import com.example.coffeeshop.models.bindingModels.LoginBindingModel;
import com.example.coffeeshop.models.serviceModels.LoginServiceModel;
import com.example.coffeeshop.services.UserService;
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
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public LoginBindingModel loginBindingModel(){
        return new LoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {
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

        LoginServiceModel loginServiceModel = userService
                .findByUsernameAndPassword(loginBindingModel.getUsername(), loginBindingModel.getPassword());

        if (loginServiceModel == null) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("isNotFound", true);

            return "redirect:login";
        }
        userService.loginUser(loginServiceModel);
        return "redirect:/";
    }
}
