package com.example.pathfinder.web;

import com.example.pathfinder.models.bindingModels.RegisterBindingModel;
import com.example.pathfinder.models.bindingModels.RouteBindingModel;
import com.example.pathfinder.services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String routes(Model model) {
        model.addAttribute("routes", this.routeService.findAllRoutes());
        return "routes";
    }

    @GetMapping("/details/{id}")
    public String route(@PathVariable Long id, Model model) {
        model.addAttribute("route", routeService.findRouteById(id));
        return "route-details";
    }

    @ModelAttribute
    public RouteBindingModel routeBindingModel(){
        return new RouteBindingModel();
    }

    @GetMapping("/add")
    public String addRoute(Model model) {
        return "add-route";
    }

}
