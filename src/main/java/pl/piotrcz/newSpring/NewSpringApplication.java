package pl.piotrcz.newSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.xml.validation.Validator;

@SpringBootApplication
public class NewSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(NewSpringApplication.class, args);
//        ConfigurableApplicationContext app = SpringApplication.run(NewSpringApplication.class, args);

//        @Bean
//        public Validator validator (MessageSource messageSource){
//            LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
//            factory.setValidationMessageSource(messageSource);
//            return factory;
//            )
        }
    }
