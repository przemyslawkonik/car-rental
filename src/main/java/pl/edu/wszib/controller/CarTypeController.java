package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.domain.entity.CarType;
import pl.edu.wszib.domain.repository.CarTypeRepository;

public class CarTypeController {
    @Autowired
    CarTypeRepository carTypeRepository;

    @GetMapping("/{brand}/{model}")
    public CarType getCarByModel(@PathVariable String brand, @PathVariable String model) {
        return carTypeRepository.findByModel(brand, model);
    }

    @GetMapping("/{enginecapacity}")
    public CarType getCarByEngineCapacity(@PathVariable String enginecapacity) {
        return carTypeRepository.findByEngineCapacity(enginecapacity);
    }


    @GetMapping("/{enginetype}")
    public CarType getCarByEngineType(@PathVariable String enginetype) {
        return carTypeRepository.findByEngineType(enginetype);
    }

    @PostMapping("/{cartype}")
    public void addTypeOfCar(@PathVariable CarType cartype) {
        carTypeRepository.save(cartype);

        System.out.println("Car type saved!");
    }
}
