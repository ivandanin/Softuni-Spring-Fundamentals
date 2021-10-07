package com.example.mobilele.web;

import com.example.mobilele.models.binding.LoginBindingModel;
import com.example.mobilele.models.service.LoginServiceModel;
import com.example.mobilele.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(LoginBindingModel loginBindingModel) {

        boolean loginSuccessful = userService.login(new LoginServiceModel()
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
