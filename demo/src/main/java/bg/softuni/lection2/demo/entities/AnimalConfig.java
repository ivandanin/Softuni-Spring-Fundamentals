package bg.softuni.lection2.demo.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean
    public Animal createCat(){
        return new Cat();
    }

    @Bean Animal createDog() {
        return new Dog();
    }
}
