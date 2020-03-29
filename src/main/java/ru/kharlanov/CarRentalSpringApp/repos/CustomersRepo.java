package ru.kharlanov.CarRentalSpringApp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kharlanov.CarRentalSpringApp.domain.Cars;
import ru.kharlanov.CarRentalSpringApp.domain.Customers;

import java.util.List;

public interface CustomersRepo extends CrudRepository<Customers, Long> {

    List<Customers> findAllById(Long id);
}