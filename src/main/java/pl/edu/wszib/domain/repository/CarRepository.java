package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.CarType;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findById(Integer id);

    Car findByCarType(String cartype);

    Car findByRentPrice(String rentprice);

    Car findByServiceDate(String servicedate);
}
