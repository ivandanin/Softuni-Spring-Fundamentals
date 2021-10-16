package com.example.pathfinder.web;

import com.example.pathfinder.models.bindingModels.LoginBindingModel;
import com.example.pathfinder.models.serviceModels.LoginServiceModel;
import com.example.pathfinder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginBindingModel loginBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

       /* if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);
            return "redirect:login";
        }

*/
        boolean loginSuccessful = userService.login(
                new LoginServiceModel()
                .setUsername(loginBindingModel.getUsername())
                .setPassword(loginBindingModel.getPassword()));

                LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                        loginBindingModel.getUsername(),
                        loginSuccessful);

                if (loginSuccessful) {
                    return "redirect:/";
                }
                return "redirect:/users/login";
    }
}
