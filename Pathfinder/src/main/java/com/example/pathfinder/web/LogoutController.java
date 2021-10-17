package com.example.pathfinder.web;

import com.example.pathfinder.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LogoutController {

    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }
}
