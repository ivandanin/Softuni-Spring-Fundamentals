package bg.softuni.lection2.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    Animal animal;

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", animal.makeNoise());
        return "test";
    }
}
