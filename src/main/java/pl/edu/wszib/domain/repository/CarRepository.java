package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.CarType;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findById(Integer id);

    List<Car> findByCarType(String cartype);

    Car findByRentPrice(String rentprice);

    Car findByServiceDate(String servicedate);
}
