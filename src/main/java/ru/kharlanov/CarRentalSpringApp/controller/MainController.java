package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kharlanov.CarRentalSpringApp.domain.*;
import ru.kharlanov.CarRentalSpringApp.repos.CarsRepo;
import ru.kharlanov.CarRentalSpringApp.repos.CustomersRepo;
import ru.kharlanov.CarRentalSpringApp.repos.RentalCarsRepo;
import ru.kharlanov.CarRentalSpringApp.repos.RentalPointRepo;

import java.util.*;

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
            @RequestParam Cars carId, //input отдает гггг-мм-дд
            @RequestParam("toRental") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toRental,
            @RequestParam("fromRental") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromRental,
            @RequestParam Customers customers,
            @RequestParam RentalPoint rentalPoint,
            Map<String, Object> model) {
        RentalCars message = new RentalCars(carId, toRental, fromRental, customers, rentalPoint);
        rentalCarsRepo.save(message); // TODO тут нужно поставить фильтр
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
        List<String> averTime = AverageRentalTime(messages2);
        Iterable<Cars> carList2 = carsRepo.findAll();
        Iterable<Customers> customerList2 = customersRepo.findAll();
        Iterable<RentalPoint> rentalPointsList2 = rentalPointRepo.findAll();
        model.addAttribute("messages", messages2);
        model.addAttribute("carList", carList2);
        model.addAttribute("customerList", customerList2);
        model.addAttribute("rentalPointsList", rentalPointsList2);
        model.addAttribute("averTimeList", averTime);
        return "filtercar";
    }

    List<String> AverageRentalTime(Iterable<RentalCars> rentalCarsList) {
        List<CarPointForFilterRentalCar> averList = new ArrayList<>();
        for (RentalCars iterRentalCars : rentalCarsList) {
            Long diffInMillies = 0l;
            long first = iterRentalCars.getToRental().getTime();
            long second = iterRentalCars.getFromRental().getTime();
            if (first != second && second > first) {
                diffInMillies = second - first;
            }
            if (!averList.isEmpty()) { //если лист не пустой
                for (int i = 0; i < averList.size(); i++) { // фор для обхода exception во время модификации листа при одновременной итерации
                    if (averList.get(i).getRentalPointId() == iterRentalCars.getRentalPointId()) { // если такой id точки уже есть в списке
                        averList.get(i).setSumRentalTime(averList.get(i).getSumRentalTime() + diffInMillies);
                        averList.get(i).setCount(averList.get(i).getCount() + 1);
                    } else { // если нет, то делаем новый
                        CarPointForFilterRentalCar carPointForFilterRentalCar = new CarPointForFilterRentalCar();
                        carPointForFilterRentalCar.setRentalpointName(iterRentalCars.getRentalPoint());
                        carPointForFilterRentalCar.setRentalPointId(iterRentalCars.getRentalPointId());
                        carPointForFilterRentalCar.setSumRentalTime(diffInMillies);
                        carPointForFilterRentalCar.setCount(1);
                        averList.add(carPointForFilterRentalCar);
                    }
                }
            } else { // это когда averList еще пустой
                CarPointForFilterRentalCar carPointForFilterRentalCar = new CarPointForFilterRentalCar();
                carPointForFilterRentalCar.setRentalpointName(iterRentalCars.getRentalPoint());
                carPointForFilterRentalCar.setRentalPointId(iterRentalCars.getRentalPointId());
                carPointForFilterRentalCar.setSumRentalTime(diffInMillies);
                carPointForFilterRentalCar.setCount(1);
                averList.add(carPointForFilterRentalCar);
            }
        }
        List<String> averTimeForEachPoint = new ArrayList<>();
        for (CarPointForFilterRentalCar currCarPointFromAverList : averList) {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Long averUnixTime = currCarPointFromAverList.getSumRentalTime() / (long) currCarPointFromAverList.getCount();
            String resultDays = new java.text.SimpleDateFormat("dd").format(new Date(averUnixTime));
            String resultHours = new java.text.SimpleDateFormat("HH").format(new Date(averUnixTime));
            StringBuilder stringBuilder = new StringBuilder();
            String jointResult = stringBuilder.append("В среднем в пункте ")
                    .append(currCarPointFromAverList.getRentalPointId())
                    .append(" ").append(currCarPointFromAverList.getRentalpointName())
                    .append(" автомобиль берут в прокат на ").append(resultDays).append(" дней и ").append(resultHours).append(" часов").toString();
            averTimeForEachPoint.add(jointResult);
        }
        return averTimeForEachPoint;
    }
}