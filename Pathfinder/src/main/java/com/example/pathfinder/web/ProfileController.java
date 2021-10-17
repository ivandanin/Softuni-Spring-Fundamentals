package com.example.pathfinder.web;

import com.example.pathfinder.models.viewModels.UserViewModel;
import com.example.pathfinder.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public ProfileController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users/profile/{id}")
    public String profile(@PathVariable Long id, Model model) {
        model.addAttribute("user",
                modelMapper.map(userService.findById(id), UserViewModel.class));

        return "profile";
    }
}
