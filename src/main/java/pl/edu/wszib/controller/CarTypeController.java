package pl.edu.wszib.controller;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.CarType;
import pl.edu.wszib.domain.repository.CarTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/carTypes")
public class CarTypeController {
    private static final Logger logger = LogManager.getLogger(CarTypeController.class);

    // Todo: we should possibly add rest of the CRUD methods

    @Autowired
    CarTypeRepository carTypeRepository;

    @GetMapping("/")
    public List<CarType> getAllCars() {
        logger.info("Retrieving all types of cars from database");
        return carTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public CarType getCarById(@PathVariable Integer id) {
        logger.info("Retrieving car type by id: " + id);
        return carTypeRepository.findById(id);
    }

    @GetMapping("/{brand}")
    public CarType getCarByModel(@PathVariable String brand) {
        logger.info("Retrieving car type by model: " + brand);
        return carTypeRepository.findByBrand(brand);
    }

    @GetMapping("/{brand}/{model}")
    public CarType getCarByModel(@PathVariable String brand, @PathVariable String model) {
        logger.info("Retrieving car type by model: " + model);
        return carTypeRepository.findByModel(brand, model);
    }

    @GetMapping("/{enginecapacity}")
    public CarType getCarByEngineCapacity(@PathVariable String enginecapacity) {
        logger.info("Retrieving car type by engine capacity: " + enginecapacity);
        return carTypeRepository.findByEngineCapacity(enginecapacity);
    }


    @GetMapping("/{enginetype}")
    public CarType getCarByEngineType(@PathVariable String enginetype) {
        logger.info("Retrieving car type by engine type: " + enginetype);
        return carTypeRepository.findByEngineType(enginetype);
    }
}
