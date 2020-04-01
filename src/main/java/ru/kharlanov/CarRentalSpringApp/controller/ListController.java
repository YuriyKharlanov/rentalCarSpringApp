package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kharlanov.CarRentalSpringApp.domain.Cars;
import ru.kharlanov.CarRentalSpringApp.domain.Customers;
import ru.kharlanov.CarRentalSpringApp.domain.RentalPoint;
import ru.kharlanov.CarRentalSpringApp.repos.CarsRepo;
import ru.kharlanov.CarRentalSpringApp.repos.CustomersRepo;
import ru.kharlanov.CarRentalSpringApp.repos.RentalPointRepo;

@Controller
public class ListController {
    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private RentalPointRepo rentalPointRepo;

    @GetMapping("/carstable")
    public String Carstable(Model model) {
        Iterable<Cars> messages;

        messages = carsRepo.findAll();

        model.addAttribute("messages", messages);
        return "carstable";
    }

    @GetMapping("/rentalpoints")
    public String RentalPoints(Model model) {
        Iterable<RentalPoint> messages;

        messages = rentalPointRepo.findAll();

        model.addAttribute("messages", messages);
        return "rentalpoints";
    }

    @GetMapping("/customers")
    public String Customers(Model model) {
        Iterable<Customers> messages;

        messages = customersRepo.findAll();

        model.addAttribute("messages", messages);
        return "customers";
    }
}