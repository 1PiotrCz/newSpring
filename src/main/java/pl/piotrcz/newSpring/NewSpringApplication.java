package pl.piotrcz.newSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(NewSpringApplication.class, args);
//        ConfigurableApplicationContext app = SpringApplication.run(NewSpringApplication.class, args);
    }
}
