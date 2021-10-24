package com.example.exam.web;

import com.example.exam.models.viewModels.ShipViewModel;
import com.example.exam.services.ShipService;
import com.example.exam.services.UserService;
import com.example.exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }
       /* List<ShipViewModel> ships = shipService.findAllShipsByHealthDesc();
        model.addAttribute("ships", ships);
        model.addAttribute("health",
                ships.stream()
                        .map(shipViewModel -> shipViewModel.getHealth(ship.getHealth()))
                        .reduce(Integer::sum).orElse(0));

        model.addAttribute("users", userService.findAllShips());

        */
        return "home";
    }
}
