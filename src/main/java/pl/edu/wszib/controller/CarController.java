package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    private CarRepository carRepository;

    @GetMapping("{/}")
    public List<Car> getAllCars() {
        logger.info("Retrieving all cars from database");
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id) {
        logger.info("Retrieving car with id: " + id);
        return carRepository.findById(id);
    }

    @GetMapping("/{servicedate}")
    public Car getCarByServicedate(@PathVariable String servicedate) {
        logger.info("Retrieving car with service date: " + servicedate);
        return carRepository.findByServiceDate(servicedate);
    }

    @GetMapping("/{rentprice}")
    public Car getCarByRentPrice(@PathVariable String rentprice) {
        logger.info("Retrieving car with rent price: " + rentprice);
        return carRepository.findByRentPrice(rentprice);
    }

    @GetMapping("/{cartype}")
    public Car getCarByCarType(@PathVariable String cartype) {
        logger.info("Retrieving car type of: " + cartype);
        return carRepository.findByCarType(cartype);
    }


    @PostMapping("/")
    public Car addCar(@RequestBody Car car) {
        logger.info("Adding car");
        return carRepository.save(car);
    }


    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car carDetails) {
        logger.info("Updating car with id: " + id);

        Car car = carRepository.findById(id);
        car.copyFieldsState(carDetails);
        Car updatedCar = carRepository.save(car);

        return updatedCar;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
        Car car = carRepository.findById(id);

        carRepository.delete(car);

        return ResponseEntity.ok().build();
    }

}
