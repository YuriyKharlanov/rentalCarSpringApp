package ru.kharlanov.CarRentalSpringApp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kharlanov.CarRentalSpringApp.domain.Customers;
import ru.kharlanov.CarRentalSpringApp.domain.RentalPoint;

import java.util.List;

public interface RentalPointRepo extends CrudRepository<RentalPoint, Long> {

    List<RentalPoint> findAllById(Long id);
}