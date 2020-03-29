package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kharlanov.CarRentalSpringApp.domain.Cars;
import ru.kharlanov.CarRentalSpringApp.domain.Customers;
import ru.kharlanov.CarRentalSpringApp.domain.RentalCars;
import ru.kharlanov.CarRentalSpringApp.domain.RentalPoint;
import ru.kharlanov.CarRentalSpringApp.repos.CarsRepo;
import ru.kharlanov.CarRentalSpringApp.repos.CustomersRepo;
import ru.kharlanov.CarRentalSpringApp.repos.RentalCarsRepo;
import ru.kharlanov.CarRentalSpringApp.repos.RentalPointRepo;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private RentalCarsRepo rentalCarsRepo;

    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    RentalPointRepo rentalPointRepo;

    @GetMapping("/")
    public String Greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/registration")
    public String Registration(Map<String, Object> model) {
        return "registration";
    }

    @GetMapping("/main")
    public String Main(/*@RequestParam(required = false, defaultValue = "") String filter,*/
                       Model model) {
        Iterable<RentalCars> messages1 = rentalCarsRepo.findAll();
        Iterable<Cars> carList1 = carsRepo.findAll();
        Iterable<Customers> customerList1 = customersRepo.findAll();
        Iterable<RentalPoint> rentalPointsList1 = rentalPointRepo.findAll();
        model.addAttribute("messages", messages1);
        model.addAttribute("carList", carList1);
        model.addAttribute("customerList", customerList1);
        model.addAttribute("rentalPointsList", rentalPointsList1);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam Cars carId, //гггг-мм-дд
            @RequestParam("toRental")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toRental,
            @RequestParam("fromRental")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromRental,
            @RequestParam Customers customers,
            @RequestParam RentalPoint rentalPoint,
            Map<String, Object> model) {
        RentalCars message = new RentalCars(carId, toRental, fromRental, customers, rentalPoint);
        rentalCarsRepo.save(message);
        Iterable<RentalCars> messages = rentalCarsRepo.findAll();
        Iterable<Cars> carList = carsRepo.findAll();
        Iterable<Customers> customerList = customersRepo.findAll();
        Iterable<RentalPoint> rentalPointsList = rentalPointRepo.findAll();
        model.put("messages", messages);
        model.put("carList", carList);
        model.put("customerList", customerList);
        model.put("rentalPointsList", rentalPointsList);
        return "main";
    }

    @GetMapping(path = "/filter/{carsId}"/*, params = "myParam=myValue"*/)
    public String findByCarsId(@PathVariable Cars carsId, Model model) {
        Iterable<RentalCars> messages2 = rentalCarsRepo.findAllByCarsId(carsId);
        //String averTime = AverageRentalTime(messages2);
        Iterable<Cars> carList2 = carsRepo.findAll();
        Iterable<Customers> customerList2 = customersRepo.findAll();
        Iterable<RentalPoint> rentalPointsList2 = rentalPointRepo.findAll();
        model.addAttribute("messages", messages2);
        model.addAttribute("carList", carList2);
        model.addAttribute("customerList", customerList2);
        model.addAttribute("rentalPointsList", rentalPointsList2);
        //model.addAttribute("averTime", averTime);
        return "main";
    }

    String AverageRentalTime(Iterable<RentalCars> rentalCarsList) {
        int count = 0;
        Long summ = 0l, unixTime = 0l;
        Iterator<RentalCars> iter = rentalCarsList.iterator();
        while(iter.hasNext()){
            count++;
            Long date = Long.parseLong(iter.next().getFromRental().toString()) - Long.parseLong(iter.next().getToRental().toString());
            summ = summ + date;
        }
        if (count > 0 ) {
             unixTime = summ/count;
        }
        String result = new java.text.SimpleDateFormat("dd HH:mm").format(new Date(unixTime * 1000));
        return result;
    }
}