package ru.kharlanov.CarRentalSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kharlanov.CarRentalSpringApp.config.MvcConfig;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MvcConfig.class);
        SpringApplication.run(ServingWebContentApplication.class, args);
    }
}
