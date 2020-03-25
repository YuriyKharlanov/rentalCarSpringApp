package ru.kharlanov.CarRentalSpringApp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kharlanov.CarRentalSpringApp.domain.Cars;

import java.util.List;

public interface CarsRepo extends CrudRepository<Cars, Long> {

    List<Cars> findAllById(String tag);
}