package com.example.exam.web;

import com.example.exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    private final CurrentUser currentUser;

    public LogoutController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("users/logout")
    public String logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        return "index";
    }
}
