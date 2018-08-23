package pl.edu.wszib.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    CarRepository carRepository;

    @GetMapping("{/}")
    public List<Car> getAllCars() {
        logger.info("retrieving all cars from database");
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id) {
        logger.info("retrieving car with id: " + id);
        return carRepository.getOne(id);
    }

    @GetMapping("/{registrationnumber}")
    public Car getCarByRegistrationNumber(@PathVariable String registrationnumber) {
        logger.info("retrieving car with registration number: " + registrationnumber);
        return carRepository.findCarByRegistrationNumber(registrationnumber);
    }

    @GetMapping("/{cartype}")
    public Car getCarByCarType(@PathVariable String cartype) {
        return carRepository.findByCarType(cartype);
    }



    @PostMapping("/{car}")
    public void addCar(@PathVariable Car car) {
        carRepository.save(car);

        System.out.println("car added");
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Integer id) {
        carRepository.getOne(id);
    }


}
