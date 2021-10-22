package com.example.coffeeshop.web;

import com.example.coffeeshop.models.bindingModels.OrderBindingModel;
import com.example.coffeeshop.models.serviceModels.OrderServiceModel;
import com.example.coffeeshop.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final ModelMapper modelMapper;
    private final OrderService orderService;

    public OrderController(ModelMapper modelMapper, OrderService orderService) {
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public String add() {
        return "order-add";
    }

    @PostMapping("/add")
    public String add(@Valid OrderBindingModel orderBindingModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderBindingModel", orderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderBindingResult", bindingResult);
            return "redirect:add";
        }

        OrderServiceModel orderServiceModel = modelMapper.map(orderBindingModel, OrderServiceModel.class);

        orderService.addOrder(orderServiceModel);

        return "redirect:/";
    }
}
