package com.example.exam.web;

import com.example.exam.models.bindingModels.AddShipBindingModel;
import com.example.exam.models.serviceModels.ShipServiceModel;
import com.example.exam.services.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class AddShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public AddShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    private AddShipBindingModel addShipBindingModel() {
        return new AddShipBindingModel();
    }

    @GetMapping("/add")
    public String addShip(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShip(@Valid AddShipBindingModel addShipBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShipBindingModel", addShipBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipBindingModel", bindingResult);

            return "redirect:add";
        }

        shipService.addShip(modelMapper.map(addShipBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }
}
