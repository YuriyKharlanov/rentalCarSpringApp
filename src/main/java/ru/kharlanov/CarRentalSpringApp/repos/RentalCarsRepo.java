package ru.kharlanov.CarRentalSpringApp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kharlanov.CarRentalSpringApp.domain.Cars;
import ru.kharlanov.CarRentalSpringApp.domain.RentalCars;

import java.util.List;

public interface RentalCarsRepo extends CrudRepository<RentalCars, Long> {

    List<RentalCars> findAllByCarsId(Cars carsId);
}