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

    //TODO: write implementation to all those methods

    @GetMapping("/{type}")
    public String getCarByType(@PathVariable String type) {
        return "car by brand";
    }

    @RequestMapping(value = "/brand/{model}")
    @GetMapping
    public String getCarByModel(@PathVariable String model) {
        return "car by model";
    }

    @RequestMapping(value = "/{enginecapacity}")
    @GetMapping
    public String getCarByEngineCapacity(@PathVariable String enginecapacity) {
        return "car by engine capacity";
    }

    @RequestMapping(value = "/{enginetype}")
    @GetMapping
    public String getCarByEngineType(@PathVariable("enginetype") String enginetype) {
        return "car by engine type";
    }

    @RequestMapping(value = "/{car}")
    @PutMapping
    public String addCar(@PathVariable("car") CarType car) {
        return "added car";
    }

    /*@RequestMapping(value = "/{id}")
    @PostMapping
    public String updateCarById(@PathVariable("id") Integer id) {
        return "car updated";
    }*/

    /*@RequestMapping(value = "/{id}")
    @DeleteMapping
    public String delCarById(@PathVariable("id") Integer id) {
        return "car removed";
    }*/

}
