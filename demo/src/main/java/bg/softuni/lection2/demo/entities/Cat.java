package bg.softuni.lection2.demo.entities;

import org.springframework.stereotype.Component;

@Component("kitty")
public class Cat implements Animal{
    @Override
    public String makeNoise() {
        return "meoww";
    }
}
