package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.CarType;
import pl.edu.wszib.domain.repository.CarRepository;
import pl.edu.wszib.domain.repository.CarTypeRepository;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarTypeRepository carTypeRepository;

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id) {
        return carRepository.getOne(id);
    }

    @GetMapping("/{type}")
    public CarType findByType(@PathVariable String type) {
        return carTypeRepository.findByType(type);
    }

    /*@GetMapping("/{brand}/{model}")
    public CarType getCarByModel(@PathVariable String brand, @PathVariable String model) {
        return carTypeRepository.findCarTypeByModel(brand, model);
    }

    @GetMapping("/{enginecapacity}")
    public CarType getCarByEngineCapacity(@PathVariable String enginecapacity) {
        return carTypeRepository.findCarTypeByEngineCapacity(enginecapacity);
    }

    @GetMapping("/{enginetype}")
    public CarType getCarByEngineType(@PathVariable String enginetype) {
        return carTypeRepository.findCarTypeByEngineType(enginetype);
    }

    @PostMapping("/{cartype}")
    public void addTypeOfCar(@PathVariable CarType cartype) {
        carTypeRepository.addTypeOfCar(cartype);

        System.out.println("car type added");
    }*/

    /*@PostMapping("/{car}")
    public void addCar(@PathVariable Car car) {
        carRepository.addCar(car);

        System.out.println("car added");
    }*/


}
