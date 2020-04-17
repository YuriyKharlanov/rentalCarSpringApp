package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kharlanov.CarRentalSpringApp.domain.Customers;
import ru.kharlanov.CarRentalSpringApp.repos.CustomersRepo;
import ru.kharlanov.CarRentalSpringApp.service.RestService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest")
public class RestsController{
    //private int counter = 100;
    @Autowired
    private CustomersRepo customersRepoRest;

    @GetMapping
    public List<Map<String, String>> list() {
        Iterable<Customers> customersList = customersRepoRest.findAll();
        List<Map<String, String>> restRequest = RestService.restRequestCustomers(customersList);
        return restRequest;
    }
/*
    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return restRequest.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));

        restRequest.add(message);

        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);

        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);

        restRequest.remove(message);
    }*/
}
