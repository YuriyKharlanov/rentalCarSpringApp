package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kharlanov.CarRentalSpringApp.domain.Cars;
import ru.kharlanov.CarRentalSpringApp.repos.CarsRepo;

import java.util.Map;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
//v
@Controller
public class MainController {
    @Autowired
    private CarsRepo carsRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Cars> carsIterable = carsRepo.findAll();

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }
}
