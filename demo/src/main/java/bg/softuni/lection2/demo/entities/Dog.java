package bg.softuni.lection2.demo.entities;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public String makeNoise() {
        return "waf-waf";
    }
}
