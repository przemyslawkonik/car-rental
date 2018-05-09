package pl.edu.wszib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
