package bg.softuni.lection2.demo.entities;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    final Animal animal;

    public TestController(@Qualifier("kitty") Animal animal) {
        this.animal = animal;
    }

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", animal.makeNoise());
        return "test";
    }
}
