package bg.softuni.Mobilele.controller;

import bg.softuni.Mobilele.model.binding.UserLoginBindingModel;
import bg.softuni.Mobilele.model.service.UserLoginServiceModel;
import bg.softuni.Mobilele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);

    private final UserService userService;


    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {

        boolean loginSuccessful = userService
                .login(new UserLoginServiceModel()
                .setUsername(userLoginBindingModel.getUsername())
                .setRawPassword(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(), loginSuccessful);

        if (loginSuccessful) {
            return "redirect:/";
        }

        return "redirect:/users/login";
    }
}
