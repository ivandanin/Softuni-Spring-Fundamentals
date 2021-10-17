package com.example.pathfinder.web;

import com.example.pathfinder.models.bindingModels.LoginBindingModel;
import com.example.pathfinder.models.serviceModels.UserServiceModel;
import com.example.pathfinder.services.UserService;
import com.example.pathfinder.util.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public LoginBindingModel loginBindingModel(){
        return new LoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("exists", true);
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginBindingModel loginBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel user = userService.findUserByUsernameAndPassword(loginBindingModel.getUsername(), loginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes.addFlashAttribute("exists", false)
                    .addFlashAttribute("loginBindingModel", loginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel", bindingResult);

            return "redirect:login";
        }

        userService.login(user.getId(), user.getUsername());

        return "redirect:/";
    }
}
