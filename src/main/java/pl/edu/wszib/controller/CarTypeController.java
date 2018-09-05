package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.domain.entity.CarType;
import pl.edu.wszib.domain.repository.CarTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/carTypes")
public class CarTypeController {

    private static final Logger logger = LogManager.getLogger(CarTypeController.class);

    @Autowired
    CarTypeRepository carTypeRepository;

    @GetMapping("/")
    public List<CarType> getAllCars() {
        logger.info("Retrieving all types of cars");
        return carTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public CarType getCarById(@PathVariable Integer id) {
        logger.info("Retrieving car type by id: " + id);
        return carTypeRepository.findById(id);
    }

    @GetMapping("/{brand}")
    public List<CarType> getCarTypesByBrand(@PathVariable String brand) {
        logger.info("Retrieving car types of brand: " + brand);
        return carTypeRepository.findAllByBrand(brand);
    }

    @GetMapping("/{brand}/{model}")
    public List<CarType> getCarTypesByModel(@PathVariable String brand, @PathVariable String model) {
        logger.info("Retrieving car types of model: " + model);
        return carTypeRepository.findAllByModel(brand, model);
    }

    @GetMapping("/{enginecapacity}")
    public List<CarType> getCarTypesByEngineCapacity(@PathVariable String enginecapacity) {
        logger.info("Retrieving car types by engine capacity: " + enginecapacity);
        return carTypeRepository.findAllByEngineCapacity(enginecapacity);
    }

    @GetMapping("/{enginetype}")
    public List<CarType> getCarTypesByEngineType(@PathVariable String enginetype) {
        logger.info("Retrieving car type by engine type: " + enginetype);
        return carTypeRepository.findAllByEngineType(enginetype);
    }
}
