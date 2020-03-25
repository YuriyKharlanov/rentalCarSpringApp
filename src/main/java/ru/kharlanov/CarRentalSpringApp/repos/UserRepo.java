package ru.kharlanov.CarRentalSpringApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kharlanov.CarRentalSpringApp.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
