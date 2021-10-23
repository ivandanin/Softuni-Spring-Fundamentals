package com.example.coffeeshop.web;

import com.example.coffeeshop.models.viewModels.OrderViewModel;
import com.example.coffeeshop.services.OrderService;
import com.example.coffeeshop.services.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final OrderService orderService;

    public HomeController(CurrentUser currentUser, UserService userService, OrderService orderService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }
        List<OrderViewModel> orders = orderService.findAllOrdersByPriceDescending();

        model.addAttribute("orders", orders);
        model.addAttribute("totalTime",
                orders.stream().map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
        .reduce(Integer::sum).orElse(0));
    model.addAttribute("users", userService.findAllUsersAndOrderCountDescending());

    return "home";
    }
}
