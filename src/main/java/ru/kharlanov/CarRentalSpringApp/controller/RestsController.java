package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kharlanov.CarRentalSpringApp.domain.Customers;
import ru.kharlanov.CarRentalSpringApp.repos.CustomersRepo;

import java.util.List;

@RestController
@RequestMapping("rest")
public class RestsController{
    @Autowired
    private CustomersRepo customersRepoRest;

    @GetMapping
    public Iterable<Customers> list() {
        return customersRepoRest.findAll();
    }

    @GetMapping("{id}")
    public List<Customers> getOne(@PathVariable String id) {
        return customersRepoRest.findAllById(Long.parseLong(id));
    }

    @PutMapping("{id}")
    public Customers update(
            @PathVariable("id") Customers messageFromDb,
            @RequestBody Customers message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");

        return customersRepoRest.save(messageFromDb);
    }
}
